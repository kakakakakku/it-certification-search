package jp.kakakakakku.certification.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import jp.kakakakakku.certification.R;
import jp.kakakakakku.certification.db.entity.CertificationEntity;

public class ListAllAdapter extends ArrayAdapter<CertificationEntity> {
    private LayoutInflater layoutInflater_;

    public ListAllAdapter(Context context, int textViewResourceId, List<CertificationEntity> objects) {
        super(context, textViewResourceId, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        CertificationEntity item = (CertificationEntity)getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = layoutInflater_.inflate(R.layout.mylist_all, null);
        }

        // CustomDataのデータをViewの各Widgetにセットする
//        ImageView imageView;
//        imageView = (ImageView)convertView.findViewById(R.id.image);
//        imageView.setImageBitmap(item.getImageData());

        TextView textView;
        textView = (TextView)convertView.findViewById(R.id.text);
        textView.setText(item.getName());

        return convertView;
    }
}
