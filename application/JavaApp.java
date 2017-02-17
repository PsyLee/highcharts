package application;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class JavaApp
{

    public JavaApp()
    {
    }

    public static Object fromJSON(TypeReference type, String jsonPacket)
    {
        Object data = null;
        try
        {
            data = (new ObjectMapper()).readValue(jsonPacket, type);
        }
        catch(JsonParseException e)
        {
            e.printStackTrace();
        }
        catch(JsonMappingException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return data;
    }

    public static String toJSON(List pojoList)
    {
        String result = null;
        try
        {
            result = (new ObjectMapper()).writeValueAsString(pojoList);
        }
        catch(JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public void print(String json)
    {
        List lista = (List)fromJSON(new TypeReference() {

            final JavaApp this$0;

            
            {
                this$0 = JavaApp.this;
                super();
            }
        }, json);
        System.out.println(lista.toString());
    }

    public String send()
    {
        List lista = new ArrayList();
        lista.add(new String("101"));
        lista.add(new String("10"));
        String str = toJSON(lista);
        return str;
    }
}
