package base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import view.BaseView;

public class BaseActivity extends Activity implements BaseView {
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("查询ing>>>>");
    }
    @Override
    public void showProgressDialog() {
        if(progressDialog!=null){
            progressDialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}
