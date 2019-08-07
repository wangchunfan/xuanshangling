package pdd;

import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.request.*;
import com.pdd.pop.sdk.http.api.response.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PddClient {
    private static final String clientId = "f046301521e042cf9aaa27308c433541";
    private static final String clientSecret = "e04b2d8499835fee1fcdaa5d282c6b97064c2592";
    private static PopClient client = new PopHttpClient(clientId, clientSecret);

    /**
     * 多多进宝商品查询
     *
     * @param keyword            商品关键词，与opt_id字段选填一个或全部填写
     * @param opt_id             商品标签类目ID，使用pdd.goods.opt.get获取
     * @param page               默认值1，商品分页数
     * @param page_size          默认100，每页商品数量
     * @param sort_type          排序方式
     * @param with_coupon        是否只返回优惠券的商品
     * @param range_list         筛选范围列表
     * @param cat_id             商品类目ID，使用pdd.goods.cats.get接口获取
     * @param goods_id_list      商品ID列表
     * @param merchant_type      店铺类型
     * @param pid                推广位id
     * @param custom_parameters  自定义参数
     * @param merchant_type_list 店铺类型数组
     * @param is_brand_goods     是否为品牌商品
     * @return
     * @throws Exception
     */
    public String goodsSearch(String keyword, Long opt_id, Integer page, Integer page_size,
                              Integer sort_type, Boolean with_coupon, String range_list,
                              Long cat_id, List<Long> goods_id_list, Integer merchant_type, String pid,
                              String custom_parameters, List<Integer> merchant_type_list, Boolean is_brand_goods) {

        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        if (keyword != null) request.setKeyword(keyword);
        if (opt_id != null) request.setOptId(opt_id);
        if (page != null) request.setPage(page);
        if (page_size != null) request.setPageSize(page_size);
        if (sort_type != null) request.setSortType(sort_type);
        if (with_coupon != null) request.setWithCoupon(with_coupon);
        if (range_list != null) request.setRangeList(range_list);
        if (cat_id != null) request.setCatId(cat_id);
        if (goods_id_list != null) request.setGoodsIdList(goods_id_list);
        if (merchant_type != null) request.setMerchantType(merchant_type);
        if (pid != null) request.setPid(pid);
        if (custom_parameters != null) request.setCustomParameters(custom_parameters);
        if (merchant_type_list != null) request.setMerchantTypeList(merchant_type_list);
        if (is_brand_goods != null) request.setIsBrandGoods(is_brand_goods);
        PddDdkGoodsSearchResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    /**
     * 多多进宝商品查询 分页
     *
     * @param page
     * @param page_size
     * @param with_coupon
     * @param pid
     * @return
     */
    public String goodsSearch(Integer page, Integer page_size, Boolean with_coupon, String pid) {
        return goodsSearch(null, null, page, page_size, null,
                with_coupon, null, null, null, null,
                pid, null, null, null);
    }

    /**
     * 多多进宝商品查询 关键字查询
     *
     * @param keyword
     * @param page
     * @param page_size
     * @return
     */
    public String goodsSearch(String keyword, Integer page, Integer page_size) {
        return goodsSearch(keyword, null, page, page_size, null, true, null, null, null, null, null, null, null, null);
    }

    /**
     * 获取热销商品列表
     *
     * @param p_id      推广位id
     * @param offset    从多少位置开始请求；默认值 ： 0
     * @param sort_type 1-实时热销榜；2-实时收益榜
     * @param limit     请求数量；默认值 ： 400
     * @return
     * @throws Exception
     */
    public String topGoodsListQuery(String p_id, Integer offset, Integer sort_type, Integer limit) {
        PddDdkTopGoodsListQueryRequest request = new PddDdkTopGoodsListQueryRequest();
        if (p_id != null) request.setPId(p_id);
        if (offset != null) request.setOffset(offset);
        if (sort_type != null) request.setSortType(sort_type);
        if (sort_type != null) request.setLimit(limit);
        PddDdkTopGoodsListQueryResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    /**
     * 多多进宝主题列表查询
     *
     * @param page_size
     * @param page
     * @return
     */
    public String themeListGet(Integer page_size, Integer page) {
        PddDdkThemeListGetRequest request = new PddDdkThemeListGetRequest();
        request.setPageSize(page_size);
        request.setPage(page);
        PddDdkThemeListGetResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    /**
     * 多多进宝主题商品查询
     *
     * @param theme_id 主题ID
     * @return
     */
    public String themeGoodsSearch(Long theme_id) {
        PddDdkThemeGoodsSearchRequest request = new PddDdkThemeGoodsSearchRequest();
        request.setThemeId(theme_id);
        PddDdkThemeGoodsSearchResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    /**
     * 商品详情查询
     *
     * @param goods_id_list
     * @return
     */
    public String goodsDetail(Long goods_id_list) {
        PddDdkGoodsDetailRequest request = new PddDdkGoodsDetailRequest();
        List<Long> goodsIdList = new ArrayList<>();
        goodsIdList.add(goods_id_list);
        request.setGoodsIdList(goodsIdList);
        PddDdkGoodsDetailResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    /**
     * 获取商品推广链接
     *
     * @param p_id
     * @param goods_id_list
     * @return
     */
    public String goodsPromotionUrlGenerate(String p_id, Long goods_id_list) {
        PddDdkGoodsPromotionUrlGenerateRequest request = new PddDdkGoodsPromotionUrlGenerateRequest();
        request.setPId(p_id);
        List<Long> goodsIdList = new ArrayList<Long>();
        goodsIdList.add(goods_id_list);
        request.setGoodsIdList(goodsIdList);
//        request.setGenerateShortUrl(false);
//        request.setMultiGroup(false);
//        request.setCustomParameters("str");
        request.setGenerateWeappWebview(true);
//        request.setZsDuoId(0L);
        request.setGenerateWeApp(true);
//        request.setGenerateWeiboappWebview(false);
        PddDdkGoodsPromotionUrlGenerateResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }
}
