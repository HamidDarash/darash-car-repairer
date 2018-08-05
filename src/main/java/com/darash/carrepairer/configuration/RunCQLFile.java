package com.darash.carrepairer.configuration;

import com.darash.carrepairer.configuration.utils.FileUtils;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.InvalidQueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public abstract class RunCQLFile {

    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    private static Logger logger = LoggerFactory.getLogger(RunCQLFile.class);
    static String CREATE_KEYSPACE;
    static String DROP_KEYSPACE;

    private Cluster cluster;
    private Session session;
    private String CQL_FILE;

    RunCQLFile(String cqlFile) {

        logger.info("Running file " + cqlFile);
        this.CQL_FILE = cqlFile;

        String contactPointsStr = contactPoints;
        if (contactPointsStr == null) {
            contactPointsStr = "127.0.0.1";
        }

        cluster = Cluster.builder().addContactPoints(contactPointsStr.split(",")).build();
        session = cluster.connect();

    }

    void internalSetup() {
        this.runfile();
    }

    void runfile() {
        String readFileIntoString = FileUtils.readFileIntoString(CQL_FILE);

        String[] commands = readFileIntoString.split("#");

        for (String command : commands) {
            System.out.println(command);
            String cql = command.trim();

            if (cql.isEmpty()) {
                continue;
            }
             this.run(cql);
        }
    }

    void runAllowFail(String cql) {
        try {
            run(cql);
        } catch (InvalidQueryException e) {
            logger.warn("Ignoring exception - " + e.getMessage());
        }
    }

    void run(String cql) {
        logger.info("Running : " + cql);
        session.execute(cql);
    }

    void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (Exception e) {
        }
    }


    void shutdown() {
        session.close();
        cluster.close();
    }
}
