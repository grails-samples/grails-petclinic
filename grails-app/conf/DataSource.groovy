import org.springframework.cloud.CloudFactory

def cloud

try {
    cloud = new CloudFactory().cloud
} catch(e) {
    println e.getMessage() +  '... because we are not running in the cloud'
}

dataSource {
	pooled = true
	driverClassName = 'org.h2.Driver'
	username = 'sa'
	password = ''
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
	cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory'
	format_sql = true
	use_sql_comments = true
}

environments {
	development {
		dataSource {
			dbCreate = 'create-drop' // one of 'create', 'create-drop', 'update', 'validate', ''
			url = 'jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000'

			// Uncomment the following line to see what SQL queries are
			// being sent to the database.
//			logSql = true
		}
	}
	test {
		dataSource {
			dbCreate = 'update'
			url = 'jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000'
		}
	}
	production {
		dataSource {
			pooled = true
			dbCreate = 'update'

			if (cloud) {
				def dbInfo = cloud.getServiceInfo('petclinic-mysql')
				driverClassName = 'com.mysql.jdbc.Driver'
				url = dbInfo.jdbcUrl
				username = dbInfo.userName
				password = dbInfo.password
			} else {
				driverClassName = 'org.h2.Driver'
				url = 'jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000'
				properties {
					maxActive = -1
					minEvictableIdleTimeMillis=1800000
					timeBetweenEvictionRunsMillis=1800000
					numTestsPerEvictionRun=3
					testOnBorrow=true
					testWhileIdle=true
					testOnReturn=true
					validationQuery='SELECT 1'
				}
			}
		}
//		grails {
//			mongo {
//				if (cloud) {
//					def mongoInfo = cloud.getServiceInfo('petclinic-mongodb')
//					host = mongoInfo.host
//					port = mongoInfo.port
//					databaseName = mongoInfo.database
//					username = mongoInfo.userName
//					password = mongoInfo.password
//				} else {
//					host = 'localhost'
//					port = 27107
//					databaseName = 'foo'
//					username = 'user'
//					password = 'password'
//				}
//			}
//			redis {
//				if (cloud) {
//					def redisInfo = cloud.getServiceInfo('petclinic-redis')
//					host = redisInfo.host
//					port = redisInfo.port
//					password = redisInfo.password
//				} else {
//					host = 'localhost'
//					port = 6379
//					password = 'password'
//				}
//			}
//		}
	}
}
