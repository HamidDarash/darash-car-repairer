use keyspacesaipa;#
DROP FUNCTION IF EXISTS  sinOf;#
CREATE OR REPLACE FUNCTION sinOf(current double) CALLED ON NULL INPUT RETURNS double LANGUAGE java AS $$return Math.sin(current);$$;#
DROP FUNCTION IF EXISTS  cosOf;#
CREATE OR REPLACE FUNCTION cosOf(current double) CALLED ON NULL INPUT RETURNS double LANGUAGE java AS $$return Math.cos(current);$$;#
DROP FUNCTION IF EXISTS  acosOf;#
CREATE OR REPLACE FUNCTION acosOf(current double) CALLED ON NULL INPUT RETURNS double LANGUAGE java AS $$return Math.acos(current);$$;#
DROP FUNCTION IF EXISTS asinOf;#
CREATE OR REPLACE FUNCTION asinOf(current double) CALLED ON NULL INPUT RETURNS double LANGUAGE java AS $$return Math.asin(current);$$;#
DROP FUNCTION IF EXISTS radiansOf;#
CREATE OR REPLACE FUNCTION radiansOf(current double) CALLED ON NULL INPUT RETURNS double LANGUAGE java AS $$return Math.toRadians(current);$$;#



