package com.techpathi.recruitbuddy;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class JobMoreActivity extends AppCompatActivity {


    private TextView jid,jrole,cname,jlocation,jdesc,jrespons,
    jqualif,jetype,lastdate,postedDate;
    private ImageView clogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_more);

        jid=(TextView)findViewById(R.id.tv_jobID);
        jrole=(TextView)findViewById(R.id.tv_job_role);
        cname=(TextView)findViewById(R.id.tv_company_name);
        jlocation=(TextView)findViewById(R.id.tv_location);
        jdesc=(TextView)findViewById(R.id.tv_description);
        jrespons=(TextView)findViewById(R.id.tv_responsibilities);
        jqualif=(TextView)findViewById(R.id.tv_qualifications);
        jetype=(TextView)findViewById(R.id.tv_employmentType);
        lastdate=(TextView)findViewById(R.id.tv_lastDate);
        postedDate=(TextView)findViewById(R.id.tv_postedon);

        clogo=(ImageView)findViewById(R.id.iv_company_logo);

        Intent moreIntent=getIntent();

        jid.setText(moreIntent.getStringExtra("jid"));
        jrole.setText(moreIntent.getStringExtra("jobtitle"));
        cname.setText(moreIntent.getStringExtra("company"));
        jlocation.setText(moreIntent.getStringExtra("location"));
        jdesc.setText(moreIntent.getStringExtra("description"));
        jrespons.setText(moreIntent.getStringExtra("responsibilities"));
        jqualif.setText(moreIntent.getStringExtra("qualifications"));
        jetype.setText(moreIntent.getStringExtra("employmenttype"));
        lastdate.setText(moreIntent.getStringExtra("applydate"));
        postedDate.setText(moreIntent.getStringExtra("postedDate"));

        String clogoUrl=moreIntent.getStringExtra("clogo");

        Picasso.get().load(clogoUrl).placeholder(R.color.placeholderlogo).into(clogo);

        }
}
