# crud-auth-bcrypt

Based on  Dan Vega application crud_auth. 
(https://github.com/danvega  , https://www.danvega.dev/ )  ----------------->
Thank you Dan Vega for your lessons,  all are great inspiration for many people.  <-------------------
In developed above project I made a few changes. 
For example there were added new features :
- bcrypt credentials & authentication based on roles ::
- as motor of database is used PostgreSQL ::
- logs are written on serwer in text file in directory named /srv/logs ::
- AdminPostController  include restriction   @Secured( {"ROLE_ADMIN" , "ROLE_KANC"} )

