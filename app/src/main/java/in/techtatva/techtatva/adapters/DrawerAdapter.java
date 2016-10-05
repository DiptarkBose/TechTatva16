package in.techtatva.techtatva.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.techtatva.techtatva.activities.FavouritesActivity;
import in.techtatva.techtatva.R;
import in.techtatva.techtatva.activities.AboutUsActivity;
import in.techtatva.techtatva.activities.InstaFeedActivity;
import in.techtatva.techtatva.activities.ResultActivity;
import in.techtatva.techtatva.models.DrawerModel;


public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder>{

    private LayoutInflater inflater;
    private List<DrawerModel> list = new ArrayList<>();
    private Activity activity;
    private DrawerLayout mDrawerLayout;

    public DrawerAdapter(Activity activity, List<DrawerModel> list, DrawerLayout mDrawerLayout) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);
        this.list = list;
        this.mDrawerLayout = mDrawerLayout;
    }

    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.drawer_item, parent, false);

        DrawerViewHolder holder = new DrawerViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {

        DrawerModel model = list.get(position);
        holder.drawerItemIcon.setImageResource(model.getIcon());
        holder.drawerItemName.setText(model.getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DrawerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView drawerItemIcon;
        TextView drawerItemName;

        public DrawerViewHolder(View itemView) {
            super(itemView);

            drawerItemIcon = (ImageView)itemView.findViewById(R.id.drawer_item_image_view);
            drawerItemName = (TextView)itemView.findViewById(R.id.drawer_item_text_view);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mDrawerLayout.closeDrawers();

            if (drawerItemName.getText().equals("Results")){
                Intent intent = new Intent(activity, ResultActivity.class);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.zoomin, R.anim.hold);
                
            }

            if (drawerItemName.getText().equals("InstaFeed")){
                Intent intent = new Intent(activity, InstaFeedActivity.class);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.zoomin, R.anim.hold);
            }

            if (drawerItemName.getText().equals("About Us")){
                Intent intent = new Intent(activity, AboutUsActivity.class);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.zoomin, R.anim.hold);
            }

            if (drawerItemName.getText().equals("Favourites")){
                Intent intent = new Intent(activity, FavouritesActivity.class);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.zoomin, R.anim.hold);
            }
        }
    }

}
