import com.google.common.collect.Maps;
import org.apache.commons.io.serialization.ValidatingObjectInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;


public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {
    private static final Logger log = LoggerFactory.getLogger(ObjectUtils.class);


    /**
     * 序列化对象
     *
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        if (object != null) {
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

                objectOutputStream.writeObject(object);
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                log.error(e.toString());
            }
        }
        return null;
    }

    /**
     * 反序列化对象
     *
     * @param bytes
     * @return
     */
    public static Object unSerialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        ValidatingObjectInputStream validatingObjectInputStream = null;
        try {
            if (bytes != null && bytes.length > 0) {
                bais = new ByteArrayInputStream(bytes);
                validatingObjectInputStream = new ValidatingObjectInputStream(bais);
                // 指定反序列化可接受类, 正常情况下需要将所有序列化时用到的类都放进去, 否则就会抛出InvalidClassException
                validatingObjectInputStream.accept("*");
                return validatingObjectInputStream.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                validatingObjectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bais.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 实体对象转成Map
     *
     * @param obj 实体对象
     * @return
     */
    public static Map<String, Object> obj2Map(Object obj) {
        Map<String, Object> map = Maps.newHashMap();
        // 判空
        if (obj == null) {
            return map;
        }
        // 利用反射获取类
        Class clazz = obj.getClass();
        // 获取参数
        Field[] fields = clazz.getDeclaredFields();
        // 参数名作为key,值
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                // 值为null,跳过
                if (Objects.nonNull(field.get(obj))) {
                    map.put(field.getName(), field.get(obj));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
