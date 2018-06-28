package com.techpathi.recruitbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.MyViewHolder> {
    private List<Jobs> jobsList;
    private Context context;
    private LayoutInflater inflater;

    public static final String KEY_JID = "jid";
    public static final String KEY_JOBTITLE = "jobtitle";
    public static final String KEY_COMPANY = "company";
    public static final String KEY_LOCATION= "location";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_RESPONSIBILITIES = "responsibilities";
    public static final String KEY_QUALIFICATIONS = "qualifications";
    public static final String KEY_ETYPE = "employmenttype";
    public static final String KEY_APPLYDATE = "applydate";
    public static final String KEY_CLOGO="clogo";
    public static final String KEY_POSTEDDATE="postedDate";





    public JobsAdapter(Context context, List<Jobs> jobsList) {

        this.context = context;
        this.jobsList = jobsList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = inflater.inflate(R.layout.rv_item_jobs, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Jobs jobs = jobsList.get(position);
        //Pass the values of feeds object to Views


        holder.tv_applydate.setText(jobs.getMapplyDate());
        holder.tv_jobtitle.setText(jobs.getMjobTitle());
        holder.tv_companyname.setText(jobs.getMcName());
        holder.tv_location.setText(jobs.getMlocation());
        Picasso.get().load(jobs.getMcLogo()).placeholder(R.color.placeholderlogo).into(holder.companylogo);




    holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent moreIntent = new Intent(v.getContext(),JobMoreActivity.class);
                moreIntent.putExtra(KEY_JID,jobs.getMjID());
                moreIntent.putExtra(KEY_JOBTITLE,jobs.getMjobTitle());
                moreIntent.putExtra(KEY_COMPANY,jobs.getMcName());
                moreIntent.putExtra(KEY_LOCATION,jobs.getMlocation());
                moreIntent.putExtra(KEY_DESCRIPTION,jobs.getMdescription());
                moreIntent.putExtra(KEY_QUALIFICATIONS,jobs.getMqualifications());
                moreIntent.putExtra(KEY_RESPONSIBILITIES,jobs.getMresponsibilities());
                moreIntent.putExtra(KEY_APPLYDATE,jobs.getMapplyDate());
                moreIntent.putExtra(KEY_ETYPE,jobs.getMemploymentType());
                moreIntent.putExtra(KEY_POSTEDDATE,jobs.getMpostedAt());
                moreIntent.putExtra(KEY_CLOGO,jobs.getMcLogo());
                v.getContext().startActivity(moreIntent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return jobsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_applydate,tv_jobtitle,tv_companyname,tv_location;
        public ImageView companylogo;
        public CardView cardView;



        public MyViewHolder(View itemView) {
            super(itemView);
            tv_companyname = itemView.findViewById(R.id.tv_company_name);
            tv_jobtitle=itemView.findViewById(R.id.tv_job_role);
            tv_applydate=itemView.findViewById(R.id.tv_applyby);
            tv_location=itemView.findViewById(R.id.tv_location);

            companylogo = itemView.findViewById(R.id.niv_company_logo);
            cardView= itemView.findViewById(R.id.jobscard);


        }


    }

}
