package yoyoHadoopCh6.configurationPrinter;

import java.util.ArrayList;
import java.util.Map.Entry;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ConfigurationPrinter extends Configured implements Tool {

    //static {
    //    Configuration.addDefaultResource("hdfs-default.xml");
    //    Configuration.addDefaultResource("hdfs-site.xml");
  //      Configuration.addDefaultResource("yarn-site.xml");
    //    Configuration.addDefaultResource("mapred-site.xml");
  //  }

    @Override
    public int run(String[] args) throws Exception {
    //    Configuration conf = getConf();
        Configuration conf = new Configuration();
        conf.addResource("yarn-site.xml");

        for (Entry<String, String> entry: conf) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());

        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new ConfigurationPrinter(), args);
        System.exit(exitCode);
    }
}