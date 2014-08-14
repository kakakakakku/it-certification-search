package jp.kakakakakku.certification.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import jp.kakakakakku.certification.R;
import jp.kakakakakku.certification.adapter.CustomSectionListAdapter;
import jp.kakakakakku.certification.adapter.SectionHeaderData;
import jp.kakakakakku.certification.adapter.SectionRowData;
import jp.kakakakakku.certification.db.entity.CertificationEntity;
import jp.kakakakakku.certification.db.model.CertificationModel;

public class ListSectionByPrimaryCategoryActivity extends Activity {

    List<CertificationEntity> cList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        // リリース用キャプチャ取得用
        // ステータスバー非表示
//        getWindow().addFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);

        CertificationModel model = new CertificationModel(ListSectionByPrimaryCategoryActivity.this);

        List<SectionHeaderData> sectionList = new ArrayList<SectionHeaderData>();
        List<List<SectionRowData>> rowList = new ArrayList<List<SectionRowData>>();

        List<SectionRowData> sectionDatalist01 = new ArrayList<SectionRowData>();
        cList = model.findAllOrderByPrimaryCategory();

        String tmpPrimaryCategory = "";
        for (CertificationEntity c: cList) {
            if (tmpPrimaryCategory.equals("")) {
                sectionList.add(new SectionHeaderData(c.getPrimaryCategory(), ""));
            } else if (!tmpPrimaryCategory.equals(c.getPrimaryCategory())) {
                rowList.add(sectionDatalist01);
                sectionDatalist01 = new ArrayList<SectionRowData>();
                sectionList.add(new SectionHeaderData(c.getPrimaryCategory(), ""));
            }
            sectionDatalist01.add(SectionRowData.getDafaultRow(c));
            tmpPrimaryCategory = c.getPrimaryCategory();
        }
        rowList.add(sectionDatalist01);

        CustomSectionListAdapter adapter = new CustomSectionListAdapter(this, sectionList, rowList);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

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
