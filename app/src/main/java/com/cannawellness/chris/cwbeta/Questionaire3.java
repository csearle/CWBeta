package com.cannawellness.chris.cwbeta;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class Questionaire3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire3);

        DBHelper db = new DBHelper(this);

        Log.d("Answers count: ", Integer.toString(db.getAnswersCount()));

        QuestionaireAnswers answers = new QuestionaireAnswers("Chris",1,1,3,"test",030617,5,15,true,false,
                "blah blah blah blahblah blahblah blahblah blahblah blahblah blahblah",
                1, "iwfbaoubawfioawfi", "fowaibfowiuabnf", "fafoiafioawf");

        QuestionaireAnswers answers2 = new QuestionaireAnswers("Doug",2,3,0,"paul",030277,0,0,true,true,
                "wuiafbaf;uawbf;aiulfbakjfawfu;baf",
                0, "aoifnafwaw", "awfinawofinwa", "oiwfnoaifnwaf");

        //String patient, int id, int relationshipStatus, int numChildren, String familyDoctor,
        //int lastTestDate, int alcConsumption, int smokeConsumption, boolean employed, boolean militaryResponder,
        //String familyHistory, int concussion, String canabisUsage, String otherTreatments, String concerns

        db.addAnswers(answers);
        db.addAnswers(answers2);

        Log.d("Answers count: ", Integer.toString(db.getAnswersCount()));
    }

}
