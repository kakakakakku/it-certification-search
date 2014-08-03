package jp.kakakakakku.certification.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import jp.kakakakakku.certification.R;
import jp.kakakakakku.certification.adapter.CustomSectionListAdapter;
import jp.kakakakakku.certification.adapter.SectionHeaderData;
import jp.kakakakakku.certification.adapter.SectionRowData;
import jp.kakakakakku.certification.db.entity.CertificationEntity;
import jp.kakakakakku.certification.db.model.CertificationModel;

public class ListSectionByOrganizationNameActivity extends Activity implements AdapterView.OnItemClickListener {

    List<CertificationEntity> cList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        CertificationModel model = new CertificationModel(ListSectionByOrganizationNameActivity.this);

        List<SectionHeaderData> sectionList = new ArrayList<SectionHeaderData>();
        List<List<SectionRowData>> rowList = new ArrayList<List<SectionRowData>>();

        List<SectionRowData> sectionDatalist01 = new ArrayList<SectionRowData>();
        cList = model.findAllOrderByOrganizationName();

        String tmpOrganizationName = "";
        for (CertificationEntity c: cList) {
            if (tmpOrganizationName.equals("")) {
                sectionList.add(new SectionHeaderData(c.getOrganizationName(), ""));
            } else if (!tmpOrganizationName.equals(c.getOrganizationName())) {
                rowList.add(sectionDatalist01);
                sectionDatalist01 = new ArrayList<SectionRowData>();
                sectionList.add(new SectionHeaderData(c.getOrganizationName(), ""));
            }
            sectionDatalist01.add(SectionRowData.getDafaultRow(c));
            tmpOrganizationName = c.getOrganizationName();
        }
        rowList.add(sectionDatalist01);

        CustomSectionListAdapter adapter = new CustomSectionListAdapter(this, sectionList, rowList);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        // 資格詳細画面に遷移するために `certifications.id` を引き継ぐ
        Intent intent = new Intent(this.getApplicationContext(), CertificationDetailActivity.class);
        intent.putExtra("id", cList.get(position - 1).getId());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
