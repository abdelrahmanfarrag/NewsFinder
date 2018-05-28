package com.example.mana.newsfinder.data.realmdatabase;

import android.content.Context;
import android.widget.Toast;
import com.example.mana.newsfinder.utilities.CommonUtils;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class DatabaseTransactions {

  public static int setPrimaryKey(Realm realm) {
    {
      try {
        return realm.where(favourites.class).max("id").intValue() + 1;
      } catch (Exception e) {
        return 0;
      }
    }
  }

  public static Realm RealmConfiguration(Context ctx) {
    Realm.init(ctx);
    RealmConfiguration config =
        new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
    Realm.setDefaultConfiguration(config);
    Realm realm = Realm.getDefaultInstance();
    return realm;
  }

  public static void insertData(Context ctx, favourites favouritesInstance, String alertTitle,
      String alertContent) {
    favouritesInstance.setId(setPrimaryKey(RealmConfiguration(ctx)));
    RealmConfiguration(ctx).beginTransaction();
    RealmConfiguration(ctx).copyToRealm(favouritesInstance);
    RealmConfiguration(ctx).commitTransaction();
    CommonUtils.alertDialogBuild(ctx, alertTitle, alertContent);
  }
  public static RealmResults<favourites> selectAllFromDb(Context ctx){
    RealmResults<favourites> favourites = RealmConfiguration(ctx).where(favourites.class).findAll();
    favourites.load();
    return favourites;
  }

}
