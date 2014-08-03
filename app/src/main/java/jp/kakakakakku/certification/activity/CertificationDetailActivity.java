package jp.kakakakakku.certification.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import jp.kakakakakku.certification.R;
import jp.kakakakakku.certification.db.entity.CertificationEntity;
import jp.kakakakakku.certification.db.model.CertificationModel;

public class CertificationDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        CertificationModel model = new CertificationModel(CertificationDetailActivity.this);
        final CertificationEntity c = model.findById(getIntent().getIntExtra("id", 1));

        // View に配置するオブジェクトを宣言する
        TextView name = (TextView)findViewById(R.id.name);
        TextView organizationName = (TextView)findViewById(R.id.organization_name);
        TextView category = (TextView)findViewById(R.id.category);
        TextView url = (TextView)findViewById(R.id.url);
        TextView price = (TextView)findViewById(R.id.price);
        TextView keywords = (TextView)findViewById(R.id.keywords);

        // オブジェクトごとに値を詰める
        name.setText(c.getName());
        organizationName.setText(c.getOrganizationName());
        category.setText(c.getPrimaryCategory());
        url.setText(c.getUrl());
        if (c.getPrice() != 0) {
            price.setText(c.getPriceWithYen());
        } else {
            price.setText("未調査");
        }
        keywords.setText(c.getKeywords());

        // オブジェクトごとに listener を実装する
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CertificationDetailActivity.this, WebViewActivity.class);
                intent.putExtra("url", c.getUrl());
                startActivity(intent);
            }
        });

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
