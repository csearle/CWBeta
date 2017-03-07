package com.cannawellness.chris.cwbeta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 8;
    // Database Name
    private static final String DATABASE_NAME = "strainsInfo";
    // Contacts table name
    private static final String TABLE_STRAINS = "strains";
    // Strains Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_LP_NAME = "lp_name";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price_per_gram";
    private static final String KEY_RATIO = "sativa_indica_ratio";
    private static final String KEY_THC_PCT = "thc_pct";
    private static final String KEY_CBD_PCT = "cbd_pct";
    private static final String KEY_LP_ID = "lp_id";
    private static final String KEY_TYPE = "strain_type";
    private static final String KEY_LP = "lp";

    // Questionaire answers table name
    private static final String TABLE_ANSWERS = "answers";
    // Answers Table Columns Names
    private static final String KEY_PATIENT = "patient";
    private static final String KEY_ID2 = "id";
    private static final String KEY_RELATIONSHIP_STATUS = "relationship_status";
    private static final String KEY_NUM_CHILDREN = "num_children";
    private static final String KEY_FAMILY_DOCTOR = "family_doctor";
    private static final String KEY_LAST_TEST_DATE = "last_test_date";
    private static final String KEY_ALC_CONSUMPTION = "alc_consumption";
    private static final String KEY_SMOKE_CONSUMPTION = "smoke_consumption";
    private static final String KEY_EMPLOYED = "employed";
    private static final String KEY_MILITARY_RESPONDER = "military_responder";
    private static final String KEY_FAMILY_HISTORY = "family_history";
    private static final String KEY_CONCUSSION = "concussion";
    private static final String KEY_CANABIS_USAGE = "canabis_usage";
    private static final String KEY_OTHER_TREATMENTS = "other_treatments";
    private static final String KEY_CONCERNS = "concerns";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STRAINS_TABLE = "CREATE TABLE " + TABLE_STRAINS + "("
                + KEY_PATIENT + " TEXT, "
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LP_NAME + " TEXT,"
                + KEY_NAME + " TEXT," + KEY_PRICE + " NUMERIC," + KEY_RATIO + " NUMERIC,"
                + KEY_THC_PCT + " NUMERIC," + KEY_CBD_PCT + " NUMERIC,"
                + KEY_LP_ID + " INTEGER," + KEY_TYPE + " TEXT," + KEY_LP + " TEXT)";
        db.execSQL(CREATE_STRAINS_TABLE);

        String CREATE_ANSWERS_TABLE = "CREATE TABLE " + TABLE_ANSWERS + "("
                + KEY_PATIENT + " TEXT,"
                + KEY_ID2 + " INTEGER PRIMARY KEY," + KEY_RELATIONSHIP_STATUS + " TEXT,"
                + KEY_NUM_CHILDREN + "INTEGER," + KEY_FAMILY_DOCTOR + "TEXT,"
                + KEY_LAST_TEST_DATE + "DATE," + KEY_ALC_CONSUMPTION + "INTEGER,"
                + KEY_SMOKE_CONSUMPTION + "INTEGER," + KEY_EMPLOYED + "BOOLEAN,"
                + KEY_MILITARY_RESPONDER + "BOOLEAN," + KEY_FAMILY_HISTORY + "BOOLEAN,"
                + KEY_CONCUSSION + "BOOLEAN," + KEY_CANABIS_USAGE + "TEXT,"
                + KEY_OTHER_TREATMENTS + "TEXT," + KEY_CONCERNS + "TEXT)";
        db.execSQL(CREATE_ANSWERS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STRAINS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWERS);
        // Creating tables again
        onCreate(db);
    }

    //Add a strain to the strains database
    public int addStrain(Strain strain) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_STRAINS + " WHERE " + KEY_NAME + " = ?";
        Cursor curs = db.rawQuery(query, new String[]{strain.getName()});
        if (curs.getCount() >= 1) {
            db.close(); // Closing database connection
            Log.d("DB", "STRAIN ALREADY EXISTS");
            return 1;
            //return 1 (Strain already exists)
        } else {


            ContentValues values = new ContentValues();
            values.put(KEY_LP_NAME, strain.getLPName());
            values.put(KEY_NAME, strain.getName());
            values.put(KEY_PRICE, strain.getPrice());
            values.put(KEY_RATIO, strain.getRatio());
            values.put(KEY_THC_PCT, strain.getTHC());
            values.put(KEY_CBD_PCT, strain.getCBD());
            values.put(KEY_LP_ID, strain.getLPid());
            values.put(KEY_TYPE, strain.getType());
            values.put(KEY_LP, strain.getLP());
            // Inserting Row
            db.insert(TABLE_STRAINS, null, values);
            db.close(); // Closing database connection
            return 0; //(Strain created);
        }
    }

    // Getting one strain
    public Strain getStrain(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_STRAINS, new String[]{KEY_ID,
                        KEY_LP_NAME, KEY_NAME, KEY_PRICE, KEY_RATIO, KEY_THC_PCT, KEY_CBD_PCT, KEY_LP_ID, KEY_TYPE, KEY_LP}, KEY_NAME + "=?",
                new String[]{name}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Strain strain = new Strain(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), Double.parseDouble(cursor.getString(3)),
                Double.parseDouble(cursor.getString(4)), Double.parseDouble(cursor.getString(5)),
                Double.parseDouble(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),
                cursor.getString(8), cursor.getString(9));
      

        // return strain
        return strain;
    }

    // Getting All Strains
    public List<Strain> getAllStrains() {
        List<Strain> strainList = new ArrayList<Strain>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_STRAINS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Strain strain = new Strain();

                strain.setId(Integer.parseInt(cursor.getString(0)));
                strain.setLPName(cursor.getString(1));
                strain.setName(cursor.getString(2));
                strain.setPrice(Double.parseDouble(cursor.getString(3)));
                strain.setRatio(Double.parseDouble(cursor.getString(4)));
                strain.setTHC(Double.parseDouble(cursor.getString(5)));
                strain.setCBD(Double.parseDouble(cursor.getString(6)));
                strain.setLPid(Integer.parseInt(cursor.getString(7)));
                strain.setType(cursor.getString(8));
                strain.setLP(cursor.getString(9));
                // Adding strain to strain list
                strainList.add(strain);
            } while (cursor.moveToNext());
        }

        // return strains list
        return strainList;
    }

    // Getting strains Count
    public int getStrainsCount() {
        String countQuery = "SELECT * FROM " + TABLE_STRAINS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    // Updating a strain
    public int updateStrain(Strain strain) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LP_NAME, strain.getLPName());
        values.put(KEY_NAME, strain.getName());
        values.put(KEY_PRICE, strain.getPrice());
        values.put(KEY_RATIO, strain.getRatio());
        values.put(KEY_THC_PCT, strain.getTHC());
        values.put(KEY_CBD_PCT, strain.getCBD());
        values.put(KEY_LP_ID, strain.getLPid());
        values.put(KEY_TYPE, strain.getType());

        // updating row
        return db.update(TABLE_STRAINS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(strain.getId())});
    }

    //delete multiple strains
    public void deleteStrains(List<Strain> strains) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i = 0; i < strains.size(); i++) {
            db.delete(TABLE_STRAINS, KEY_ID + " = ?",
                    new String[]{String.valueOf(strains.get(i).getId())});
        }
    }

    // Deleting a strain
    public void deleteStrain(Strain strain) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STRAINS, KEY_ID + " = ?",
                new String[]{String.valueOf(strain.getId())});
        db.close();
    }

    public int addAnswers(QuestionaireAnswers answers) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_ANSWERS + " WHERE " + KEY_PATIENT + " = ?";
        Cursor curs = db.rawQuery(query, new String[]{answers.getPatient()});
        if (curs.getCount() >= 1) {
            db.close(); // Closing database connection
            Log.d("DB", "ANWSERS ALREADY EXIST");
            return 1;
            //return 1 (Answers already exist)
        } else {


            ContentValues values = new ContentValues();
            values.put(KEY_PATIENT, answers.getPatient());
            values.put(KEY_RELATIONSHIP_STATUS, answers.getRelationshipStatus());
            values.put(KEY_NUM_CHILDREN, answers.getNumChildren());
            values.put(KEY_FAMILY_DOCTOR, answers.getFamilyDoctor());
            values.put(KEY_LAST_TEST_DATE, answers.getLastTestDate());
            values.put(KEY_ALC_CONSUMPTION, answers.getAlcConsumption());
            values.put(KEY_SMOKE_CONSUMPTION, answers.getSmokeConsumption());
            values.put(KEY_EMPLOYED, answers.getEmployed());
            values.put(KEY_MILITARY_RESPONDER, answers.getMilitaryResponder());
            values.put(KEY_FAMILY_HISTORY, answers.getFamilyHistory());
            values.put(KEY_CONCUSSION, answers.getConcussion());
            values.put(KEY_CANABIS_USAGE, answers.getCanabisUsage());
            values.put(KEY_OTHER_TREATMENTS, answers.getOtherTreatments());
            values.put(KEY_CONCERNS, answers.getConcerns());
            // Inserting Row
            db.insert(TABLE_ANSWERS, null, values);
            db.close(); // Closing database connection
            return 0; //(Strain created);
        }
    }

    // Getting one strain
    public QuestionaireAnswers getAnswers(String patient) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ANSWERS, new String[]{KEY_PATIENT, KEY_ID2, KEY_RELATIONSHIP_STATUS,
                        KEY_NUM_CHILDREN, KEY_FAMILY_DOCTOR, KEY_LAST_TEST_DATE, KEY_ALC_CONSUMPTION, KEY_SMOKE_CONSUMPTION,
                        KEY_EMPLOYED, KEY_MILITARY_RESPONDER, KEY_FAMILY_HISTORY, KEY_CONCUSSION, KEY_CANABIS_USAGE,
                        KEY_OTHER_TREATMENTS, KEY_CONCERNS}, KEY_PATIENT + "=?",
                new String[]{patient}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        QuestionaireAnswers answers = new QuestionaireAnswers(cursor.getString(0), Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), cursor.getString(4),
                Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),
                Boolean.parseBoolean(cursor.getString(8)), Boolean.parseBoolean(cursor.getString(9)), cursor.getString(10),
                Integer.getInteger(cursor.getString(11)), cursor.getString(12), cursor.getString(13), cursor.getString(14));

        // return answers
        return answers;
    }

    // Deleting a strain
    public void deleteAnswers(QuestionaireAnswers answers) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ANSWERS, KEY_PATIENT + " = ?",
                new String[]{String.valueOf(answers.getPatient())});
        db.close();
    }


    // Updating an answer
    public int updateAnswers(QuestionaireAnswers answers) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PATIENT, answers.getPatient());
        values.put(KEY_RELATIONSHIP_STATUS, answers.getRelationshipStatus());
        values.put(KEY_NUM_CHILDREN, answers.getNumChildren());
        values.put(KEY_FAMILY_DOCTOR, answers.getFamilyDoctor());
        values.put(KEY_LAST_TEST_DATE, answers.getLastTestDate());
        values.put(KEY_ALC_CONSUMPTION, answers.getAlcConsumption());
        values.put(KEY_SMOKE_CONSUMPTION, answers.getSmokeConsumption());
        values.put(KEY_EMPLOYED, answers.getEmployed());
        values.put(KEY_MILITARY_RESPONDER, answers.getMilitaryResponder());
        values.put(KEY_FAMILY_HISTORY, answers.getFamilyHistory());
        values.put(KEY_CONCUSSION, answers.getConcussion());
        values.put(KEY_CANABIS_USAGE, answers.getCanabisUsage());
        values.put(KEY_OTHER_TREATMENTS, answers.getOtherTreatments());
        values.put(KEY_CONCERNS, answers.getConcerns());

        // updating row
        return db.update(TABLE_ANSWERS, values, KEY_PATIENT + " = ?",
                new String[]{String.valueOf(answers.getPatient())});
    }

    public int getAnswersCount() {
        String countQuery = "SELECT * FROM " + TABLE_ANSWERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }


}