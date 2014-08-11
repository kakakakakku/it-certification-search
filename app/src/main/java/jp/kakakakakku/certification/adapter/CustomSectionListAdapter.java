package jp.kakakakakku.certification.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import jp.kakakakakku.certification.R;
import jp.kakakakakku.certification.activity.CertificationDetailActivity;

public class CustomSectionListAdapter extends BaseSectionAdapter<SectionHeaderData, SectionRowData> {

    Context mContext;
    public CustomSectionListAdapter(Context context, List<SectionHeaderData> sectionList, List<List<SectionRowData>> rowList) {
        super(context, sectionList, rowList);
        this.mContext = context;
    }

    @Override
    public View viewForHeaderInSection(View convertView, int section) {
        ListHeaderViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.mylist_section_header, null);
            holder = new ListHeaderViewHolder();
            holder.titleTxt = (TextView) convertView.findViewById(R.id.titleTxt);
            holder.subtitleTxt = (TextView) convertView.findViewById(R.id.subtitleTxt);
            convertView.setTag(holder);
        } else {
            holder = (ListHeaderViewHolder) convertView.getTag();
        }
        SectionHeaderData headerData = sectionList.get(section);
        holder.titleTxt.setText(headerData.title);
        holder.subtitleTxt.setText(headerData.subTitle);
        return convertView;
    }

    @Override
    public View cellForRowAtIndexPath(View convertView, final IndexPath indexPath) {
        ListRowViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.mylist_section_body, null);
            holder = new ListRowViewHolder();
            holder.idTxt = (TextView) convertView.findViewById(R.id.idTxt);
            holder.labelTxt = (TextView) convertView.findViewById(R.id.labelTxt);
            holder.valueTxt = (TextView) convertView.findViewById(R.id.valueTxt);
            holder.rowArea = (LinearLayout) convertView.findViewById(R.id.row_area);
            convertView.setTag(holder);
        } else {
            holder = (ListRowViewHolder) convertView.getTag();
        }

        final SectionRowData rowData = rowList.get(indexPath.section).get(indexPath.row);
        holder.idTxt.setText(rowData.id.toString());
        holder.labelTxt.setText(rowData.label);
        holder.valueTxt.setText(rowData.value.toString());
        holder.rowArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CertificationDetailActivity.class);
                intent.putExtra("id", rowData.id);
               mContext. startActivity(intent);
            }
        });

        return convertView;
    }

    static class ListHeaderViewHolder {
        TextView titleTxt;
        TextView subtitleTxt;
    }

    static class ListRowViewHolder {
        TextView idTxt;
        TextView labelTxt;
        TextView valueTxt;
        LinearLayout rowArea;
    }
}
