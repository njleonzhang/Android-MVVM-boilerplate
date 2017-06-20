package com.leon.mvvm.ui;

import com.leon.mvvm.R;
import com.leon.mvvm.ui.base.mvvm.BaseVMActivity;
import com.leon.mvvm.ui.base.mvvm.BaseViewModel;

/**
 * Created by leon on 2017/6/20.
 */

public class MainViewModel extends BaseViewModel {
    public static final String TYPE_HOUSE_KEEPER_REQ_REPAIR = "repair";
    public static final String TYPE_HOUSE_KEEPER_REQ_HELP = "help";

    public MainViewModel(BaseVMActivity activity) {
        super(activity);
    }

    public int getReqIcon(String reqType) {
        return reqType.equals(TYPE_HOUSE_KEEPER_REQ_HELP)
            ? R.drawable.ic_house_keeper_help_circle
            : R.drawable.ic_house_keeper_repair_circle;
    }
}
