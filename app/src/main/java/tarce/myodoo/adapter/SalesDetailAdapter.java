package tarce.myodoo.adapter;

import android.graphics.Color;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import tarce.model.GetSaleResponse;
import tarce.myodoo.R;

/**
 * Created by Daniel.Xu on 2017/4/21.
 */

public class SalesDetailAdapter extends BaseQuickAdapter<GetSaleResponse.TResult.TRes_data.TPack_operation_product_ids,BaseViewHolder> {
    public SalesDetailAdapter(int layoutResId, List<GetSaleResponse.TResult.TRes_data.TPack_operation_product_ids> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GetSaleResponse.TResult.TRes_data.TPack_operation_product_ids item) {
        helper.setText(R.id.product,item.getProduct_id().getName())
                .setText(R.id.need_in,"位置: "+item.getProduct_id().getArea_id().getArea_name())
                .setText(R.id.origin_qty, "初始需求: "+item.getOrigin_qty()+"")
                .setText(R.id.inventory,"可用: "+(item.getProduct_id().getQty_available()-item.getReserved_qty()))
                .setText(R.id.need_out,"待出库: "+item.getProduct_qty()+"")
                .setText(R.id.done,"完成: "+item.getQty_done()+"")
                .setText(R.id.line_num, helper.getPosition()+1+".")
                .setText(R.id.baoliu, "保留: "+item.getReserved_qty()+"");
        if (item.getPack_id() == -1){
            helper.setTextColor(R.id.product, Color.GRAY)
                    .setTextColor(R.id.need_in,Color.GRAY)
                    .setTextColor(R.id.origin_qty, Color.GRAY)
                    .setTextColor(R.id.inventory,Color.GRAY)
                    .setTextColor(R.id.need_out,Color.GRAY)
                    .setTextColor(R.id.line_num, Color.GRAY);
            helper.setTextColor(R.id.done,Color.GRAY)
            .setTextColor(R.id.baoliu, Color.GRAY);
        }else if (item.getOrigin_qty()>item.getProduct_qty()){
            helper.setTextColor(R.id.product, Color.RED)
                    .setTextColor(R.id.need_in,Color.RED)
                    .setTextColor(R.id.origin_qty, Color.RED)
                    .setTextColor(R.id.inventory,Color.RED)
                    .setTextColor(R.id.need_out,Color.RED)
                    .setTextColor(R.id.line_num, Color.RED);
                    helper.setTextColor(R.id.done,Color.RED)
                            .setTextColor(R.id.baoliu, Color.RED);
        }else {
            helper.setTextColor(R.id.product, Color.BLACK)
                    .setTextColor(R.id.need_in,Color.BLACK)
                    .setTextColor(R.id.origin_qty, Color.BLACK)
                    .setTextColor(R.id.inventory,Color.BLACK)
                    .setTextColor(R.id.need_out,Color.BLACK)
                    .setTextColor(R.id.line_num, Color.BLACK);
                    helper.setTextColor(R.id.done,Color.BLACK)
                            .setTextColor(R.id.baoliu, Color.BLACK);
        }
    }
}
