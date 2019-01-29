<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${BasePackageName}${DaoPackageName}.${ClassName}Dao">

    <resultMap id="${EntityName}ResultMap" type="${BasePackageName}${EntityPackageName}.${ClassName}">
        ${ResultMap}
       <#-- ${Association}-->
        ${Collection}
    </resultMap>

    <sql id="${EntityName}Columns">
        ${ColumnMap}
    </sql>

    <sql id="${EntityName}Joins">
        ${Joins}
    </sql>

    <insert id="insertSelective" parameterType="${BasePackageName}${EntityPackageName}.${ClassName}">
        INSERT INTO ${TableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >
            ${InsertProperties}
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
            ${InsertValues}
        </trim>
    </insert>

    <insert id="insertSelectiveBatch" >
        INSERT INTO ${TableName}
       (
        ${InsertBarchProperties}
        )
        VALUES
        <foreach collection ="list" item="${EntityName}" separator =",">
            (
                ${InsertBatchValues}
            )
        </foreach>
    </insert>

    <select id="findList" resultMap="${EntityName}ResultMap" parameterType="map">
        SELECT
        <include refid="${EntityName}Columns" />
        FROM ${TableName} ${TableShortName} <include refid="${EntityName}Joins" />
        WHERE 1=1
        ${WhereParams}
        <#-- AND ${TableName}.name LIKE concat('%',#{name},'%')-->
    </select>

    <select id="findListCount" resultType="java.lang.Integer" parameterType="map">
        SELECT count(1）
            FROM ${TableName} ${TableShortName} <include refid="${EntityName}Joins" />
        WHERE 1=1
        ${WhereParams}
        <#-- AND ${TableName}.name LIKE concat('%',#{name},'%')-->
    </select>


    <select id="findById" resultMap="${EntityName}ResultMap">
            SELECT
        <include refid="${EntityName}Columns" />
            FROM ${TableName} ${TableShortName} <include refid="${EntityName}Joins" />
        <where>
            ${PrimaryKey} = ${Id}
        </where>
    </select>

    <update id="updateSelective">
        UPDATE ${TableName} SET
        ${UpdateProperties}
        WHERE ${PrimaryKey} = ${WhereId}
    </update>

    <update id="delete">
        DELETE FROM ${TableName}
        WHERE ${PrimaryKey} = ${WhereId}
    </update>

</mapper>