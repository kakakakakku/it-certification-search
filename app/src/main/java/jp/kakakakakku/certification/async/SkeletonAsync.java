package jp.kakakakakku.certification.async;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;

import jp.kakakakakku.certification.callback.Callback;
import jp.kakakakakku.certification.db.entity.CertificationEntity;
import jp.kakakakakku.certification.db.model.CertificationModel;

/**
 * 情報登録AsyncTask<br>
 * <br>
* /getArticles
 * 
 */
public class SkeletonAsync extends AsyncTask<Object, Integer, String > {

    private ArrayList<CertificationEntity>  mArrAPrivate ;
    private Context  mContext ;

    private Callback mCallback;

    private ProgressDialog dialog;
	public SkeletonAsync(Context context,ArrayList<CertificationEntity> array,Callback callback) {
		super();
        this.mContext = context;
        this.mArrAPrivate = array;
        this.mCallback = callback;
	}

	@Override
	protected void onPreExecute() {
        dialog = new ProgressDialog(mContext);
        dialog.setMessage("保存中");
        dialog.show();
     }



	@Override
	protected String doInBackground(Object... params) {
        CertificationModel model = new CertificationModel(mContext);
        model.saveAll(mArrAPrivate);

        return "";
	}

	@Override
	protected void onPostExecute(String result) {
        dialog.dismiss();
        mCallback.onSuccessInit();

		
	}
}
