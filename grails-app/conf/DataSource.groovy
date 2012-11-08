dataSource {
	pooled = true
	driverClassName = 'org.h2.Driver'
	username = 'sa'
	password = ''
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
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
			dbCreate = 'update'
			url = 'jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000'
			pooled = true
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
}
