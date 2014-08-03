package jp.kakakakakku.certification.callback;


import java.util.ArrayList;

import jp.kakakakakku.certification.db.entity.CertificationEntity;

public interface Callback {
	void onSuccessInit();

	void onFailedInit();

}
