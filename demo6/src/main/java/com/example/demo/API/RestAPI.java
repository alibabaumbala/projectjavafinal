package com.example.demo.API;


import com.example.demo.responsitory.RepmessageRepository;
import com.example.demo.responsitory.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.services.VoucherService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
//@Configurable
public class RestAPI
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService ;

    @Autowired
    VoucherService voucherService;


    API api = new API();
    @Autowired
    private RepmessageRepository repmessageRepository;

    //    String uriAPI = "http://localhost:3001/api/listhotel";
   public String restAPIString(int index,String location, String idHotel,String key) throws JSONException
   { //không tìm được list-room

       int indexHotel = findIndexKey(0,location,"id",idHotel);
       LinkedHashMap<String, ArrayList> listhashmap = new LinkedHashMap<>();
       listhashmap = (LinkedHashMap<String, ArrayList>) api.webclient().get(index); //lấy ở trường nào?

       JSONObject object = new JSONObject(listhashmap);
       JSONArray jArray = object.getJSONArray(location); //tỉnh thành muốn lấy
       JSONObject jObj = new JSONObject(String.valueOf((JSONObject) jArray.get(indexHotel))); //vị trí của khách sạn muốn lấy
       String extract = recurseKeys(jObj, key); //key muốn lấy
       return extract; //kết quả trả về
   }


    public JSONObject restAPIStringHotelDetail(int index) throws JSONException, IOException
    {

        LinkedHashMap<String, ArrayList> listhashmap = new LinkedHashMap<>();
        listhashmap = (LinkedHashMap<String, ArrayList>) api.webclient().get(index); //lấy ở trường nào?
        List<Object> listValues = new ArrayList<Object>(listhashmap.values());

        int indexHotel = findIndexKey(0,"phuquoc","id","pq-hotel-1");
        JSONObject object = new JSONObject(listhashmap);
        JSONArray jArray = object.getJSONArray("phuquoc"); //tỉnh thành muốn lấy
        JSONObject jObj = new JSONObject(String.valueOf((JSONObject) jArray.get(indexHotel))); //vị trí của khách sạn muốn lấy
        return jObj;
    }

    public int findIndexKey(int index,String local,String key, String keyNeedFindIndex) throws JSONException
    {
        ArrayList<String> listIndexHotel = new ArrayList<>();
        LinkedHashMap<String, ArrayList> listhashmap = new LinkedHashMap<>();
        listhashmap = (LinkedHashMap<String, ArrayList>) api.webclient().get(index); //ấy ở trường nào
        JSONObject object = new JSONObject(listhashmap);


        JSONArray jArray3 = object.getJSONArray(local); //tỉnh thành
        for(int i = 0; i < jArray3 .length(); i++)
        {
            JSONObject object3 = jArray3.getJSONObject(i);
            listIndexHotel.add(object3.getString(key)); //key muốn lấy
        }
        return  listIndexHotel.indexOf(keyNeedFindIndex); //giá trị truyền vào để tìm vị trí
    }

    //lấy ra các thông tin phòng
    public String findInfoRoom(int index, String location, String idHotel,String idRoom,String keyInRoom) throws JSONException {
        String roomList = restAPIString(index,location,idHotel,"list_room");
        JSONArray array = new JSONArray(roomList);

        int findIndexByIdRoom = -1;
        for(int i=0; i < array.length(); i++)
        {
            JSONObject object = array.getJSONObject(i);
            if(object.getString("idroom").equals(idRoom)==true)
            {
                findIndexByIdRoom=i;
            }
        }
        return array.getJSONObject(findIndexByIdRoom).getString(keyInRoom);
    }
    public static String recurseKeys(JSONObject jObj, String findKey) throws JSONException
    {
        String finalValue = "";
        if (jObj == null) {
            return "";
        }

        Iterator<String> keyItr = jObj.keys();
        Map<String, String> map = new HashMap<>();

        while(keyItr.hasNext()) {
            String key = keyItr.next();
            map.put(key, jObj.getString(key));
        }

        for (Map.Entry<String, String> e : (map).entrySet()) {
            String key = e.getKey();
            if (key.equalsIgnoreCase(findKey)) {
                return jObj.getString(key);
            }

            // Đọc giá trị value
            Object value = jObj.get(key);

            if (value instanceof JSONObject) {
                finalValue = recurseKeys((JSONObject)value, findKey);
            }
        }

        // không tìm thấy key
        return finalValue;
    }
}
