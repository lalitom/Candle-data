package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class TestData {

	
	public static LinkedHashMap<String,HashMap<String,Double>>testdata(int diff,String str)
	{
		LinkedHashMap<String,HashMap<String,Double>> temp=new LinkedHashMap<String,HashMap<String,Double>>();
		HashMap<String,Double> ohlcv=null;
		String today="Today";
		 for (int i=0;i<5;i++ )
		 {
			 ohlcv=new HashMap<String,Double>();
		  ohlcv.put("open", 270.45+i+diff);
         ohlcv.put("close", 272.45+i+diff);
		  ohlcv.put("high", 274.45+i+diff);
		  ohlcv.put("low", 268.45+i+diff);
		  temp.put(str+i, ohlcv);
		 }
	//	System.out.println(temp);
		
		return temp;
	}
	
	public static HashMap<String, LinkedHashMap<String, Double>> getcandledata(LinkedHashMap<String, HashMap<String, Double>> linkedHashMap)
	{
		LinkedHashMap<String,Double> temp=new LinkedHashMap<String,Double>();
		LinkedHashMap<String,LinkedHashMap<String,Double>> temps=new LinkedHashMap<String,LinkedHashMap<String,Double>>();
		Set<String> set=linkedHashMap.keySet();
		String name="";
		
		int counter =0;
		
		List<Double> ltrhigh=new ArrayList<Double>();
		List<Double> ltrlow=new ArrayList<Double>();
	
		for(String s:set)
		{
			if(counter==0)
			{
				temp.put("open",linkedHashMap.get(s).get("open"));
			}
			ltrhigh.add(linkedHashMap.get(s).get("high"));
		//	System.out.println("ltrhigh"+ltrhigh);
			List<Double> ltropen= new ArrayList<Double>();
			ltropen.add(linkedHashMap.get(s).get("open"));
			ltrlow.add(linkedHashMap.get(s).get("low"));
			List<Double> ltrclose= new ArrayList<Double>();
			ltrclose.add(linkedHashMap.get(s).get("close"));
			
			if(counter==set.size()-1)
			{
				temp.put("close",linkedHashMap.get(s).get("close"));
				name=s;
			}
			
			counter++;
		}
		Collections.sort(ltrhigh);
        Collections.sort(ltrlow);
		temp.put("high",ltrhigh.get(ltrhigh.size()-1));
	    temp.put("low",ltrlow.get(0));
	 //   System.out.println(name);
	   // System.out.println(temp);
	   // System.out.println(temps);
	    temps.put(name,temp);
	  //  System.out.println(temps);
	    return  temps;
     	
		
	}
}
