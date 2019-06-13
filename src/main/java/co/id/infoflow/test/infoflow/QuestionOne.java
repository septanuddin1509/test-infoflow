package co.id.infoflow.test.infoflow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *  Data Store and Load
 *  Author septanuddin s
 */
public class QuestionOne 
{
	public static void main(String[] args){

		String arrayString = "key1=value1;key2=value2\nkeyA=valueA\n";
		HashMap<String,String>[] keyValueMaps = loadStringToArray(arrayString);
		System.out.println(keyValueMaps[0].get("key1"));
		System.out.println(keyValueMaps[0].get("key2"));
		System.out.println(keyValueMaps[1].get("keyA"));

		System.out.println(storeArrayMapToString(keyValueMaps));
	}


	public static HashMap<String,String>[] loadStringToArray(String string){

		if(string!=null && string.length()>0){
			/**
			 * key1=value;key2=value2
			 * keyA=valueA
			 */
			String[] keyValueArr = string.split("\n");
			if(keyValueArr.length>0){
				@SuppressWarnings("unchecked")
				HashMap<String, String>[] a = (HashMap<String, String>[])new HashMap[keyValueArr.length];
				for(int i=0;i<keyValueArr.length;++i){
					String keyValues = keyValueArr[i];
					HashMap<String,String> map = new HashMap<String,String>();
					if(keyValues.split(";").length>0){
						for(String keyValueItems:keyValues.split(";")){
							String[] keyValue = keyValueItems.split("=");
							map.put(keyValue[0], keyValue[1]);
						}
					}else{
						String[] keyValue = keyValues.split("=");
						map.put(keyValue[0], keyValue[1]);
					}
					a[i] = map;
				}
				return a;
			}
		}

		return null;
	}


	public static String storeArrayMapToString(HashMap<String,String>[] arrMap){
		if(arrMap.length>0){
			StringBuilder builder = new StringBuilder();
			for(int i=0;i<arrMap.length;++i){
				HashMap<String,String> map = arrMap[i];
				Iterator<Entry<String,String>> iterator = map.entrySet().iterator();
				while(iterator.hasNext()){
					Entry<String,String> entry =  iterator.next();
					String key = entry.getKey();
					String value = entry.getValue();
					builder.append(key).append("=").append(value).append(";");
				}
				builder.deleteCharAt(builder.lastIndexOf(";"));
				if(i!=arrMap.length-1){
					builder.append("\n");
				}
			}

			return builder.toString();
		}
		return "";
	}
}
