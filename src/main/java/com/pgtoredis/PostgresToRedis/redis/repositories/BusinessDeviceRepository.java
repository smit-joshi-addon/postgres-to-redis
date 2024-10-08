package com.pgtoredis.PostgresToRedis.redis.repositories;

import com.pgtoredis.PostgresToRedis.redis.model.BusinessDevice;
import com.redis.om.spring.annotations.*;
import com.redis.om.spring.repository.RedisDocumentRepository;

import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import org.springframework.stereotype.Repository;
import redis.clients.jedis.search.SearchResult;
import redis.clients.jedis.search.aggr.AggregationResult;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface BusinessDeviceRepository extends RedisDocumentRepository<BusinessDevice, Long> {

    /* FT.SEARCH "com.pgtoredis.PostgresToRedis.redis.model.BusinessDeviceIdx" "@businessBusinessId_businessId:[451 451]"
     Return 1 businessDeviceId ... returnFields = "businessDeviceId"  */
    @Query(value = "@businessBusinessId_businessId:[$businessId $bId]")
    List<BusinessDevice> findDeviceByBusinessId(Integer businessId, Integer bId);

    @Query(value = "@businessBusinessId_businessId:[$businessId $bId]", returnFields = "businessDeviceId")
    List<Map<String, Object>> findDeviceByBusinessIdMap(Integer businessId, Integer bId);

    @Query(value = "@businessBusinessId_businessId:[$businessId $bId]", returnFields = {"businessDeviceId", "businessBusinessId_businessId"})
    SearchResult findDeviceByBusinessIdList(Integer businessId, Integer bId);

    @Query("@businessDeviceId:[$businessId $bDId]")
    Optional<BusinessDevice> findByBusinessDeviceId(Long businessDeviceId, Long bdId);

    List<BusinessDevice> findByBusinessBusinessId_GpsLocationNear(Point point, Distance distanceKm);


    @Aggregation(
            groupBy = {
                    @GroupBy(
                            properties = "@businessBusinessId_businessId",
                            reduce = @Reducer(func = ReducerFunction.COUNT_DISTINCT, args = {"@businessDeviceId"}, alias = "BusinessDeviceCount")
                    )
            },
            sortBy = {
                    @SortBy(field = "@BusinessDeviceCount", direction = Sort.Direction.DESC)
            }
    )
    AggregationResult distinctBusinessId();

    // this only count record but upper count BusinessDeviceId
    @Aggregation(
            value = "@isActive:{true}",
            groupBy = {
                    @GroupBy(
                            properties = "@businessBusinessId_businessId",
                            reduce = {
                                    @Reducer(func = ReducerFunction.COUNT_DISTINCT, args = {"@businessDeviceId"}, alias = "BusinessDeviceCount"),
                                    @Reducer(func = ReducerFunction.TOLIST, args = {"@businessDeviceId"}, alias = "BusinessDeviceList")
                            }
                    )
            },
            sortBy = {
                    @SortBy(field = "@BusinessDeviceCount", direction = Sort.Direction.DESC),
            }
    )
    AggregationResult activeBusinessDeviceList();

    /*"FT.AGGREGATE" "com.pgtoredis.PostgresToRedis.redis.model.BusinessDeviceIdx" "@isActive:{true}" "GROUPBY" "1" "@businessBusinessId_businessId" "REDUCE" "COUNT_DISTINCT" "1" "@businessDeviceId" "AS" "BusinessDeviceCount"
    "REDUCE" "TOLIST" "1" "@businessDeviceId" "AS" "BusinessDeviceList" "REDUCE" "TOLIST" "1" "@businessBusinessId_mobileNumber" "AS" "MobileNumber" "SORTBY" "2" "@BusinessDeviceCount" "DESC" "LIMIT" "0" "10000"*/
    @Aggregation(
            value = "@isActive:{true}",
            groupBy = {
                    @GroupBy(
                            properties = "@businessBusinessId_businessId",
                            reduce = {
                                    @Reducer(func = ReducerFunction.COUNT_DISTINCT, args = {"@businessDeviceId"}, alias = "BusinessDeviceCount"),
                                    @Reducer(func = ReducerFunction.TOLIST, args = {"@businessDeviceId"}, alias = "BusinessDeviceList"),
                                    @Reducer(func = ReducerFunction.TOLIST, args = {"@businessBusinessId_mobileNumber"}, alias = "MobileNumber")
                            }
                    )
            },
            sortBy = {
                    @SortBy(field = "@BusinessDeviceCount", direction = Sort.Direction.DESC),
            }
    )
    AggregationResult activeBusinessDeviceWithNumberList();

    /*"FT.AGGREGATE" "com.pgtoredis.PostgresToRedis.redis.model.BusinessDeviceIdx" "@businessBusinessId_gpsLocation:[72.556529 23.038023 10 km]" "LOAD" "3" "@businessBusinessId_gpsLocation" "AS" "location"
    "APPLY" "geodistance(@location, 72.556529,23.038023)" "AS" "" "LIMIT" "0" "10000"*/
    @Aggregation(
            value = "@businessBusinessId_gpsLocation:[72.556529 23.038023  10 km]",
            load = @Load(property = "@businessBusinessId_gpsLocation", alias = "location"),
            apply = @Apply(expression = "geodistance(@location,72.556529 ,23.038023)", alias = "distance"),
            sortBy = @SortBy(field = "@distance", direction = Sort.Direction.DESC)

    )
    AggregationResult geoLocationDistance();


    @Aggregation(
            apply = @Apply(expression = "geodistance($point1, $point2)", alias = "distance")
    )
    AggregationResult geoPersonDistance(Point point1, Point point2);


    /*"FT.AGGREGATE" "com.pgtoredis.PostgresToRedis.redis.model.BusinessDeviceIdx" "@isActive:{true}" "GROUPBY" "1" "@businessBusinessId_businessId"
     "REDUCE" "COUNT_DISTINCT" "1" "@businessDeviceId" "AS" "BusinessDeviceCount" "REDUCE" "TOLIST" "1" "@businessDeviceId" "AS" "BusinessDeviceList" "SORTBY" "2" "@BusinessDeviceCount" "DESC" "LIMIT" "0" "10000"*/
    @Aggregation(
            groupBy = {
                    @GroupBy(
                            properties = "@businessBusinessId_businessId",
                            reduce = {@Reducer(func = ReducerFunction.COUNT, alias = "count")}
                    )
            }
    )
//List<Map<String,Object>> groupByBusinessId();
    AggregationResult groupByBusinessId();

    @Aggregation(
            groupBy = {
                    @GroupBy(
                            properties = "@businessBusinessId_businessId",
                            reduce = {
                                    @Reducer(func = ReducerFunction.COUNT_DISTINCT, args = {"@businessDeviceId"}, alias = "BusinessDeviceCount"),
                                    @Reducer(func = ReducerFunction.TOLIST, args = {"@businessDeviceId"}, alias = "BusinessDeviceList")
                            }
                    )
            },
            load = @Load(property = "@businessDeviceId"),
            sortBy = {
                    @SortBy(field = "@BusinessDeviceCount", direction = Sort.Direction.DESC),
                    //@SortBy(field = "@businessDeviceId", direction = Sort.Direction.ASC)
            }
            //,limit = 10
    )
    AggregationResult businessDeviceIdList();


}
