package com.chnMicro.MFExchange.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.chnMicro.MFExchange.R;
import com.chnMicro.MFExchange.Request;
import com.chnMicro.MFExchange.RequestMaker;
import com.chnMicro.MFExchange.WJSClient;
import com.chnMicro.MFExchange.bean.BaseResp;
import com.chnMicro.MFExchange.bean.Loan;
import com.chnMicro.MFExchange.util.LogUtil;
import com.chnMicro.MFExchange.util.Prompter;
import com.chnMicro.MFExchange.view.LoanCircleProgress;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Enel on 2015/3/8.
 */
public class TypedMoneyFragment extends BaseFragment {
    public static final String MONEY_TYPE = "MONEY_TYPE";  //理财产品类型
    private int moneyType;
    private List<Loan> loanList;

    @InjectView(R.id.lv_loans) ListView lvLoans;

    @Override protected int getLayoutRes() {
        return R.layout.fragment_money_typed;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTopbarText("", "理财", "");

        Bundle bundle = getArguments();
        moneyType = bundle.getInt(MONEY_TYPE);
        Prompter.toast(getActivity(), ""+moneyType);

        //TODO:
        if (2 == moneyType) {   //微投资
            Request wtzLoanListReq = RequestMaker.MONEY.getWTZLoanListReq(1, 10);
            post(wtzLoanListReq, new WJSClient.WJSBaseJsonHttpResponseHandler() {
                @Override protected void onRealSuccess(BaseResp response) {
                    loanList = gson.fromJson(response.result, new TypeToken<List<Loan>>() {
                    }.getType());

                    //setup list data
                    setupListData();

                    for (Loan loan : loanList) {
                        LogUtil.info(loan.getLoanName());
                    }

                }
            });
        }else {
            TextView tv = new TextView(getActivity());
            tv.setText(MoneyFragment.typeNames[moneyType]);
            ((ViewGroup) view).addView(tv);
        }
    }

    private void setupListData() {
        BaseAdapter adapter = new LoanAdapter();
        lvLoans.setAdapter(adapter);
    }

    /**
     * 兼容：微投资、
     */
    public class LoanAdapter extends BaseAdapter {
        @Override public int getCount() {
            return loanList.size();
        }

        @Override public Object getItem(int position) {
            return position;
        }

        @Override public long getItemId(int position) {
            return position;
        }

        @Override public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView != null) {
                holder = (ViewHolder) convertView.getTag();
            } else {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.item_loan, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }

            Loan loan = loanList.get(position);
            holder.title.setText(loan.getLoanName());
            holder.rate.setText("" + loan.getInterestRate() + "%");
            holder.period.setText(loan.getRepaymentMonth());
            holder.level.setText(loan.getGradeIdType());
            holder.progress.setProgress((int) loan.getProgress());

            return convertView;
        }

        class ViewHolder {
            ViewHolder(View view) {
                ButterKnife.inject(this, view);
            }

            @InjectView(R.id.title) TextView title;
            @InjectView(R.id.rate) TextView rate;
            @InjectView(R.id.period) TextView period;
            @InjectView(R.id.level) TextView level;//星级
            @InjectView(R.id.progress) LoanCircleProgress progress;
        }
    }
}
