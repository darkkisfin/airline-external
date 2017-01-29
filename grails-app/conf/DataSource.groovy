dataSource {//create schema airlineexternal character set utf8 collate utf8_swedish_ci;
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
    username = "gradutaustadb"
    password = "vatupassi24televisio17Kissapeto"
    properties { 
                validationQuery="select 1" 
                testWhileIdle=true 
                timeBetweenEvictionRunsMillis=60000 
        } 
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

environments {
    development {
        dataSource {
	    dbCreate = "create-drop"
	    url = "jdbc:mysql://localhost/airlineexternal?useUnicode=yes&characterEncoding=UTF-8"
        }
    }
    test {
        dataSource {
	    dbCreate = "create-drop"
	    url = "jdbc:mysql://localhost/airlineexternaltest?useUnicode=yes&characterEncoding=UTF-8"
	}
    }
    production {
        dataSource {
	    dbCreate = "create-drop"
	    url = "jdbc:mysql://localhost/airlineexternal?useUnicode=yes&characterEncoding=UTF-8"
	}
    }
}
