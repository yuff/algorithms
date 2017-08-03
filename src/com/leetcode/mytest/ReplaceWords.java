package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
	public static void main(String[] args) {
		ReplaceWords rw = new ReplaceWords();
		String[] list = new String[] {"e", "k", "c", "harqp", "h", "gsafc", "vn", "lqp", "soy", "mr", "x", "iitgm",
		                              "sb", "oo", "spj", "gwmly", "iu", "z", "f", "ha", "vds", "v", "vpx", "fir", "t",
		                              "xo", "apifm", "tlznm", "kkv", "nxyud", "j", "qp", "omn", "zoxp", "mutu", "i",
		                              "nxth", "dwuer", "sadl", "pv", "w", "mding", "mubem", "xsmwc", "vl", "farov",
		                              "twfmq", "ljhmr", "q", "bbzs", "kd", "kwc", "a", "buq", "sm", "yi", "nypa", "xwz",
		                              "si", "amqx", "iy", "eb", "qvgt", "twy", "rf", "dc", "utt", "mxjfu", "hm", "trz",
		                              "lzh", "lref", "qbx", "fmemr", "gil", "go", "qggh", "uud", "trnhf", "gels",
		                              "dfdq", "qzkx", "qxw"};
		List<String> dict = new ArrayList<>();
		for (String s : list) {
			dict.add(s);
		}
		String sen = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";
		System.out.println(rw.replaceWords(dict, sen));
	}

	public String replaceWords(List<String> dict, String sentence) {
		if (sentence == null || sentence.isEmpty() || dict == null || dict.size() == 0) {
			return sentence;
		}
		Collections.sort(dict);
		Map<Character, List<String>> map = new HashMap<>();
		String pre = null;
		for (String s : dict) {
			char c = s.charAt(0);
			if (map.get(c) == null) {
				map.put(c, new ArrayList<String>());
			}
			if (pre == null) {
				pre = s;
				map.get(c).add(s);
			}
			else {
				if (!s.startsWith(pre)) {
					pre = s;
					map.get(c).add(s);
				}
			}
		}
		String[] strs = sentence.split(" ");
		int length = strs.length;
		String[] res = new String[length];
		for (int i = 0; i < length; i++) {
			res[i] = replace(strs[i], map);
		}
		StringBuilder builder = new StringBuilder();
		for (String s : res) {
			builder.append(s);
			builder.append(" ");
		}
		String result = builder.toString();
		return result.substring(0, result.length() - 1);
	}

	private String replace(String s, Map<Character, List<String>> map) {
		List<String> root = map.get(s.charAt(0));
		if (root == null || root.size() == 0) {
			return s;
		}
		for (String r : root) {
			if (s.startsWith(r)) {
				return r;
			}
		}
		return s;
	}
}
