package xin.sunce.chapter4.reflect.chapter9;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 〈文件类加载器〉
 *
 * @author ce.sun
 * @create 2018-09-25
 */
public class FileClassLoader extends ClassLoader {


    private String rootPath;

    public FileClassLoader(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> c = findLoadedClass(name);

        //应该要先查询有没有加载过这个类。如果已经加载，则直接返回加载好的类。如果没有，则加载新的类。
        if(c!=null){
            return c;
        }else{
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            } catch (Exception e) {
                 e.printStackTrace();
            }

            if(c!=null){
                return c;
            }else{
                byte[] classData = getClassData(name);
                if(classData==null){
                    throw new ClassNotFoundException();
                }else{
                    c = defineClass(name, classData, 0,classData.length);
                }
            }

        }

        return c;

    }

    private byte[] getClassData(String classname){
        String path = rootPath +"/"+ classname.replace('.', '/')+".class";

        // IOUtils,可以使用它将流中的数据转成字节数组
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            is = new FileInputStream(path);

            byte[] buffer = new byte[1024];
            int temp=0;
            while((temp=is.read(buffer))!=-1){
                baos.write(buffer, 0, temp);
            }

            return baos.toByteArray();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            try {
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(baos!=null){
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
