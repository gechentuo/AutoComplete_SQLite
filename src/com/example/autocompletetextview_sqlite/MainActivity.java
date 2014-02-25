package com.example.autocompletetextview_sqlite;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity {

	MyAutoCompleteTextView myAutoComplete;

	ArrayAdapter<String> myAdapter;

	DatabaseHandler dbHandler;

	String[] item = new String[] { "Please search..." };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbHandler = new DatabaseHandler(MainActivity.this);
		
		insertSampleData();
		 
		myAutoComplete = (MyAutoCompleteTextView)findViewById(R.id.myautocomplete);
		myAutoComplete.addTextChangedListener(new AutocompleteTextChangedListener(this));
		
		myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);
		myAutoComplete.setAdapter(myAdapter);
	}

	public void insertSampleData() {
		String info = "北京市 天津市 石家庄市 石家庄市 唐山市 秦皇岛市 邯郸市 邯郸市 邢台市 保定市 张家口市 承德市 沧州市 廊坊市 衡水市 太原市 大同市 阳泉市 阳泉市 长治市 晋城市 朔州市 忻州市 吕梁市 吕梁市 晋中市 临汾市 运城市 呼和浩特市 包头市 乌海市 赤峰市 呼伦贝尔市 兴安盟 兴安盟 通辽市 锡林郭勒盟 乌兰察布盟 伊克昭盟 巴彦淖尔盟 巴彦淖尔盟 阿拉善盟 沈阳市 大连市 鞍山市 抚顺市 本溪市 本溪市 丹东市 锦州市 营口市 阜新市 辽阳市 盘锦市 铁岭市 朝阳市 葫芦岛市 长春市 吉林市 四平市 辽源市 通化市 通化市 白山市 松原市 白城市 延边朝鲜族自治州 哈尔滨市 齐齐哈尔市 鸡西市 鹤岗市 双鸭山市 大庆市 伊春市 七台河市 牡丹江市 黑河市 绥化市 大兴安岭地区 上海市 南京市 无锡市 无锡市 徐州市 常州市 苏州市 南通市 连云港市 连云港市 淮阴市 盐城市 扬州市 镇江市 泰州市 宿迁市 杭州市 杭州市 宁波市 温州市 嘉兴市 湖州市 绍兴市 绍兴市 金华市 衢州市 舟山市 台州市 丽水市 合肥市 芜湖市 蚌埠市 淮南市 马鞍山市 淮北市 铜陵市 安庆市 黄山市 黄山市 滁州市 阜阳市 宿州市 六安市 宣城市 巢湖市 池州市 福州市 厦门市 宁德市 莆田市 泉州市 漳州市 漳州市 龙岩 三明市 南平市 南昌市 景德镇市 萍乡市 九江市 新余市 鹰潭市 赣州市 宜春市 宜春市 上饶市 吉安市 抚州市 济南市 济南市 青岛市 淄博市 枣庄市 东营市 烟台市 潍坊市 济宁市 泰安市 威海市 日照市 莱芜市 临沂市 临沂市 德州市 聊城市 滨州地区 菏泽地区 郑州市 郑州市 开封市 洛阳市 平顶山市 安阳市 安阳市 鹤壁市 新乡市 焦作市 濮阳市 许昌市 漯河市 漯河市 三门峡市 南阳市 商丘市 信阳市 周口市 周口市 驻马店地区 省直辖行政单位 武汉市 黄石市 十堰市 宜昌市 宜昌市 襄樊市 鄂州市 荆门市 孝感市 荆州市 黄冈市 咸宁市 恩施土家族苗族自治州 省直辖行政单位 长沙市 株洲市 湘潭市 衡阳市 衡阳市 邵阳市 岳阳市 常德市 张家界市 益阳市 郴州市 永州市 怀化市 娄底地区 湘西土家族苗族自治州 广州市 韶关市 深圳市 珠海市 汕头市 佛山市 江门市 江门市 湛江市 茂名市 肇庆市 惠州市 梅州市 汕尾市 河源市 河源市 阳江市 清远市 东莞市 中山市 潮州市 揭阳市 云浮市 南宁市 柳州市 柳州市 桂林市 梧州市 北海市 防城港市 钦州市 贵港市 玉林市 玉林市 崇左市 来宾市 贺州市 百色市 河池市 省直辖行政单位 海口市 三亚市 重庆市 成都市 自贡市 攀枝花市 泸州市 泸州市 德阳市 绵阳市 广元市 遂宁市 内江市 乐山市 南充市 南充市 宜宾市 广安市 达川地区 雅安地区 阿坝藏族羌族自治州 阿坝藏族羌族自治州 甘孜藏族自治州 凉山彝族自治州 巴中地区 眉山地区 眉山地区 资阳地区 贵阳市 六盘水市 遵义市 铜仁地区 黔西南布依族苗族自治州 黔西南布依族苗族自治州 毕节地区 安顺地区 黔东南苗族侗族自治州 黔南布依族苗族自治州 昆明市 曲靖市 玉溪市 昭通地区 楚雄彝族自治州 楚雄彝族自治州 红河哈尼族彝族自治州 文山壮族苗族自治州 思茅市 西双版纳傣族自治州 大理白族自治州 大理白族自治州 保山地区 德宏傣族景颇族自治州 丽江地区 怒江傈僳族自治州 迪庆藏族自治州 临沧地区 拉萨市 昌都地区 昌都地区 山南地区 日喀则地区 那曲地区 阿里地区 阿里地区 林芝地区 西安市 铜川市 宝鸡市 咸阳市 咸阳市 渭南市 延安市 汉中市 安康地区 安康地区 商洛地区 榆林地区 兰州市 嘉峪关市 金昌市 白银市 天水市 天水市 酒泉地区 张掖地区 武威地区 定西地区 陇南地区 平凉地区 庆阳地区 庆阳地区 临夏回族自治州 甘南藏族自治州 西宁市 海东地区 海北藏族自治州 黄南藏族自治州 海南藏族自治州 果洛藏族自治州 果洛藏族自治州 玉树藏族自治州 海西蒙古族藏族自治州 银川市 石嘴山市 吴忠市 固原地区 中卫市 乌鲁木齐市 克拉玛依市 克拉玛依市 吐鲁番地区 哈密地区 昌吉回族自治州 博尔塔拉蒙古自治州 巴音郭楞蒙古自治州 阿克苏地区 克孜勒苏柯尔克孜自治州 喀什地区 喀什地区 和田地区 伊犁哈萨克自治州 塔城地区 阿勒泰地区";
		String[] citys = info.split(" ");
		for (String city : citys) {
			dbHandler.create(new City(city));
		}
	}

	public String[] getItemsFromDb(String searchItem) {
		List<City> cities = dbHandler.read(searchItem);
		int rowCount = cities.size();

		String[] item = new String[rowCount];
		int x = 0;

		for (City city : cities) {
			item[x] = city.cityName;
			x++;
		}
		return item;
	}
}
