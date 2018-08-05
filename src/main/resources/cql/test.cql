//CREATE OR REPLACE FUNCTION distanceOf(lat1 double,lng1 double,lat2 double,lng2 double)
//CALLED ON NULL INPUT RETURNS double
//LANGUAGE java AS '
//double theta = lng1 - lng2;
//double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
//dist = Math.acos(dist);
//dist = Math.toRadians(dist);
//dist = dist * 2 * 1.1515;
//return Math.toRadians(dist);
//';
//select distanceOf(latlng.lat,latlng.lng,42.15444,34.58511) as "meter" from user_by_location ;
//
//
//CREATE  VIEW user_by_location_view
//AS SELECT id, distanceOf(latlng.lat,latlng.lng,42.15444,34.58511) as meter
//FROM user_by_location
//PRIMARY KEY (id)
//WITH caching = { 'keys' : 'ALL', 'rows_per_partition' : '100' }
//AND comment = 'list location' ;