package jp.kakakakakku.certification.db.model;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import jp.kakakakakku.certification.db.DatabaseHelper;
import jp.kakakakakku.certification.db.entity.CertificationEntity;

public class CertificationModel {

	private static final String TAG = CertificationModel.class.getSimpleName();
	private Context context;

	public CertificationModel(Context context) {
		this.context = context;
	}

    public List<CertificationEntity> findAll() {
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            Dao<CertificationEntity, Integer> dao = helper.getDao(CertificationEntity.class);
            return dao.queryForAll();
        } catch (Exception e) {
            Log.e(TAG, "例外が発生しました", e);
            return null;
        } finally {
            helper.close();
        }
    }

    public List<CertificationEntity> findAllOrderByOrganizationName() {
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            Dao<CertificationEntity, Integer> dao = helper.getDao(CertificationEntity.class);
            return dao.queryBuilder().orderBy("organizationName", true).query();
        } catch (Exception e) {
            Log.e(TAG, "例外が発生しました", e);
            return null;
        } finally {
            helper.close();
        }
    }

    public List<CertificationEntity> findAllOrderByPrimaryCategory() {
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            Dao<CertificationEntity, Integer> dao = helper.getDao(CertificationEntity.class);
            return dao.queryBuilder().orderBy("primaryCategory", true).query();
        } catch (Exception e) {
            Log.e(TAG, "例外が発生しました", e);
            return null;
        } finally {
            helper.close();
        }
    }

    public List<CertificationEntity> findAllOrderByPrice() {
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            Dao<CertificationEntity, Integer> dao = helper.getDao(CertificationEntity.class);
            return dao.queryBuilder().orderBy("price", true).where().notIn("price", 0).query();
        } catch (Exception e) {
            Log.e(TAG, "例外が発生しました", e);
            return null;
        } finally {
            helper.close();
        }
    }

    public CertificationEntity findById(int id) {
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            Dao<CertificationEntity, Integer> dao = helper.getDao(CertificationEntity.class);
            return dao.queryForId(id);
        } catch (Exception e) {
            Log.e(TAG, "例外が発生しました", e);
            return null;
        } finally {
            helper.close();
        }
    }

//    public List<CertificationEntity> findGroupByOrganizationName() {
//        DatabaseHelper helper = new DatabaseHelper(context);
//        try {
//            Dao<CertificationEntity, Integer> dao = helper.getDao(CertificationEntity.class);
//            return dao.queryBuilder().groupBy("organizationName").query();
//        } catch (Exception e) {
//            Log.e(TAG, "例外が発生しました", e);
//            return null;
//        } finally {
//            helper.close();
//        }
//    }

    /**
	 * insert or updateする
	 * 
	 * @param word
	 *            対象のエンティティ
	 */
	public void save(CertificationEntity word) {
		DatabaseHelper helper = new DatabaseHelper(context);
		try {
			Dao<CertificationEntity, Integer> dao = helper.getDao(CertificationEntity.class);
			dao.createOrUpdate(word);
		} catch (Exception e) {
			Log.e(TAG, "例外が発生しました", e);
		} finally {
			helper.close();
		}
	}

    public void saveAll(ArrayList<CertificationEntity> word) {
        DatabaseHelper helper = new DatabaseHelper(context);
        try {
            Dao<CertificationEntity, Integer> dao = helper.getDao(CertificationEntity.class);
            for (CertificationEntity c: word) {
                dao.createOrUpdate(c);
            }
        } catch (Exception e) {
            Log.e(TAG, "例外が発生しました", e);
        } finally {
            helper.close();
        }
    }

    /**
	 * deleteする
	 * 
	 * @param word
	 *            対象のエンティティ
	 * @return 削除件数
	 */
	public int delete(CertificationEntity word) {
		DatabaseHelper helper = new DatabaseHelper(context);
		try {
			Dao<CertificationEntity, Integer> dao = helper.getDao(CertificationEntity.class);
			return dao.delete(word);
		} catch (Exception e) {
			Log.e(TAG, "例外が発生しました", e);
		} finally {
			helper.close();
		}
		return 0;
    }


	/**
	 * 全件を削除する
	 * 
	 * @return 削除件数
	 */
	public int deleteAll() {
		DatabaseHelper helper = new DatabaseHelper(context);
		try {
			Dao<CertificationEntity, Integer> dao = helper.getDao(CertificationEntity.class);
			return dao.delete(findAll());
		} catch (Exception e) {
			Log.e(TAG, "例外が発生しました", e);
		} finally {
			helper.close();
		}
		return 0;
	}

}
