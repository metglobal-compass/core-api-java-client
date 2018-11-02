package compass_api.service;

import java.util.Map;

public class QueryProcessingService {

    public static String getQueryParsingervice(
            Map<String, String> queryMap
    ){
        String queryString="";
        int index = 0;

        for (Map.Entry<String, String> mapItem: queryMap.entrySet()){

            if (queryMap.entrySet().size() == 1){
                queryString += "?"+mapItem.getKey() + "=" +mapItem.getValue();
            } else {
                if (index==0) {
                    queryString += "?" + mapItem.getKey() + "=" + mapItem.getValue();
                } else {
                    queryString += "&" + mapItem.getKey() + "=" + mapItem.getValue();
                }
            }
            index++;
        }
        return queryString;
    }
}

