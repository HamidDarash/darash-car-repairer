use keyspacesaipa;#
CREATE SEARCH INDEX ON user_by_location WITH OPTIONS {lenient: true};#
ALTER SEARCH INDEX SCHEMA ON user_by_location ADD types.fieldtype [ @class='solr.LatLonType' , @name='location' , @subFieldSuffix='_coordinate' ];#
ALTER SEARCH INDEX SCHEMA ON user_by_location ADD types.fieldtype [ @class='solr.TrieDoubleField' , @name='tdouble' , @precisionStep='8' , @positionIncrementGap='0' ];#
ALTER SEARCH INDEX SCHEMA ON user_by_location drop field location;#
ALTER SEARCH INDEX SCHEMA ON user_by_location ADD fields.field[ @name='location',@type='location',@indexed='true',@stored='true' ];#
ALTER SEARCH INDEX SCHEMA ON user_by_location ADD fields.dynamicField [ @name='*_coordinate',@type='tdouble',@indexed='true',@stored='false' ];#
RELOAD SEARCH INDEX ON user_by_location;#
CREATE SEARCH INDEX ON user_request_by_location WITH OPTIONS {lenient: true};#
ALTER SEARCH INDEX SCHEMA ON user_request_by_location ADD types.fieldtype [ @class='solr.LatLonType' , @name='location' , @subFieldSuffix='_coordinate' ];#
ALTER SEARCH INDEX SCHEMA ON user_request_by_location ADD types.fieldtype [ @class='solr.TrieDoubleField' , @name='tdouble' , @precisionStep='8' , @positionIncrementGap='0' ];#
ALTER SEARCH INDEX SCHEMA ON user_request_by_location drop field location;#
ALTER SEARCH INDEX SCHEMA ON user_request_by_location ADD fields.field[ @name='location',@type='location',@indexed='true',@stored='true' ];#
ALTER SEARCH INDEX SCHEMA ON user_request_by_location ADD fields.dynamicField [ @name='*_coordinate',@type='tdouble',@indexed='true',@stored='false' ];#
RELOAD SEARCH INDEX ON user_request_by_location;#
CREATE SEARCH INDEX ON pit_shops WITH OPTIONS {lenient: true};#
ALTER SEARCH INDEX SCHEMA ON pit_shops ADD types.fieldtype [ @class='solr.LatLonType' , @name='location' , @subFieldSuffix='_coordinate' ];#
ALTER SEARCH INDEX SCHEMA ON pit_shops ADD types.fieldtype [ @class='solr.TrieDoubleField' , @name='tdouble' , @precisionStep='8' , @positionIncrementGap='0' ];#
ALTER SEARCH INDEX SCHEMA ON pit_shops drop field location;#
ALTER SEARCH INDEX SCHEMA ON pit_shops ADD fields.field[ @name='location',@type='location',@indexed='true',@stored='true' ];#
ALTER SEARCH INDEX SCHEMA ON pit_shops ADD fields.dynamicField [ @name='*_coordinate',@type='tdouble',@indexed='true',@stored='false' ];#
RELOAD SEARCH INDEX ON pit_shops;#