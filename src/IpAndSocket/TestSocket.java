package IpAndSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yejunyu
 * @date 2018/1/7.
 */
public class TestSocket {
    public static void main(String[] args) {
        try {
            for (int i = 1; i < 254; i++) {
                Process p = Runtime.getRuntime().exec("ping -t 3 "+"192.168.1."+i);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = null;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null){
                    if (line.length() != 0){
                        sb.append(line+'\n');
                    }
                }
                if (sb.toString().contains("0 packets received")){
                    continue;
                }
                System.out.println(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
