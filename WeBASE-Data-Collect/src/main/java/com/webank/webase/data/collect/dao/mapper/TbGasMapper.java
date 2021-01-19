package com.webank.webase.data.collect.dao.mapper;

import com.webank.webase.data.collect.dao.entity.TbGas;
import com.webank.webase.data.collect.dao.entity.TbGasExample;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TbGasMapper {
    
    @Select({ "select * from tb_gas", "where chain_id = #{chainId,jdbcType=INTEGER}", "and group_id = #{groupId,jdbcType=INTEGER}", "and user_address = #{userAddress,jdbcType=VARCHAR}", "and block_number >= #{blockNumber,jdbcType=BIGINT}", "order by block_number,trans_index" })
    @Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), @Result(column = "record_month", property = "recordMonth", jdbcType = JdbcType.INTEGER, id = true), @Result(column = "chain_id", property = "chainId", jdbcType = JdbcType.INTEGER), @Result(column = "group_id", property = "groupId", jdbcType = JdbcType.INTEGER), @Result(column = "block_number", property = "blockNumber", jdbcType = JdbcType.BIGINT), @Result(column = "trans_hash", property = "transHash", jdbcType = JdbcType.VARCHAR), @Result(column = "trans_index", property = "transIndex", jdbcType = JdbcType.INTEGER), @Result(column = "block_timestamp", property = "blockTimestamp", jdbcType = JdbcType.TIMESTAMP), @Result(column = "user_address", property = "userAddress", jdbcType = JdbcType.VARCHAR), @Result(column = "record_type", property = "recordType", jdbcType = JdbcType.TINYINT), @Result(column = "gas_value", property = "gasValue", jdbcType = JdbcType.BIGINT), @Result(column = "gas_remain", property = "gasRemain", jdbcType = JdbcType.BIGINT), @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP), @Result(column = "modify_time", property = "modifyTime", jdbcType = JdbcType.TIMESTAMP) })
    List<TbGas> getGasListForReconciliation(@Param("chainId") int chainId, @Param("groupId") int groupId, @Param("userAddress") String userAddress, @Param("blockNumber") long blockNumber);

    @Delete({ "delete from tb_gas", "where chain_id = #{chainId,jdbcType=INTEGER}" })
    int deleteByChainId(@Param("chainId") int chainId);

    @Delete({ "delete from tb_gas", "where chain_id = #{chainId,jdbcType=INTEGER}", "and group_id = #{groupId,jdbcType=INTEGER}", "and block_number = #{blockNumber,jdbcType=BIGINT}" })
    void rollback(@Param("chainId") int chainId, @Param("groupId") int groupId, @Param("blockNumber") long blockNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     */
    @Insert({ "insert into tb_gas (record_month, chain_id, ", "group_id, block_number, ", "trans_hash, trans_index, ", "block_timestamp, user_address, ", "record_type, gas_value, ", "gas_remain, create_time, ", "modify_time)", "values (#{recordMonth,jdbcType=INTEGER}, #{chainId,jdbcType=INTEGER}, ", "#{groupId,jdbcType=INTEGER}, #{blockNumber,jdbcType=BIGINT}, ", "#{transHash,jdbcType=VARCHAR}, #{transIndex,jdbcType=INTEGER}, ", "#{blockTimestamp,jdbcType=TIMESTAMP}, #{userAddress,jdbcType=VARCHAR}, ", "#{recordType,jdbcType=TINYINT}, #{gasValue,jdbcType=BIGINT}, ", "#{gasRemain,jdbcType=BIGINT}, NOW(), NOW())" })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(TbGas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @SelectProvider(type = TbGasSqlProvider.class, method = "countByExample")
    long countByExample(TbGasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @DeleteProvider(type = TbGasSqlProvider.class, method = "deleteByExample")
    int deleteByExample(TbGasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @Delete({ "delete from tb_gas", "where id = #{id,jdbcType=INTEGER}", "and record_month = #{recordMonth,jdbcType=INTEGER}" })
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("recordMonth") Integer recordMonth);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @InsertProvider(type = TbGasSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(TbGas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @SelectProvider(type = TbGasSqlProvider.class, method = "selectByExample")
    @Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), @Result(column = "record_month", property = "recordMonth", jdbcType = JdbcType.INTEGER, id = true), @Result(column = "chain_id", property = "chainId", jdbcType = JdbcType.INTEGER), @Result(column = "group_id", property = "groupId", jdbcType = JdbcType.INTEGER), @Result(column = "block_number", property = "blockNumber", jdbcType = JdbcType.BIGINT), @Result(column = "trans_hash", property = "transHash", jdbcType = JdbcType.VARCHAR), @Result(column = "trans_index", property = "transIndex", jdbcType = JdbcType.INTEGER), @Result(column = "block_timestamp", property = "blockTimestamp", jdbcType = JdbcType.TIMESTAMP), @Result(column = "user_address", property = "userAddress", jdbcType = JdbcType.VARCHAR), @Result(column = "record_type", property = "recordType", jdbcType = JdbcType.TINYINT), @Result(column = "gas_value", property = "gasValue", jdbcType = JdbcType.BIGINT), @Result(column = "gas_remain", property = "gasRemain", jdbcType = JdbcType.BIGINT), @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP), @Result(column = "modify_time", property = "modifyTime", jdbcType = JdbcType.TIMESTAMP) })
    List<TbGas> selectByExample(TbGasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @Select({ "select", "id, record_month, chain_id, group_id, block_number, trans_hash, trans_index, ", "block_timestamp, user_address, record_type, gas_value, gas_remain, create_time, ", "modify_time", "from tb_gas", "where id = #{id,jdbcType=INTEGER}", "and record_month = #{recordMonth,jdbcType=INTEGER}" })
    @Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), @Result(column = "record_month", property = "recordMonth", jdbcType = JdbcType.INTEGER, id = true), @Result(column = "chain_id", property = "chainId", jdbcType = JdbcType.INTEGER), @Result(column = "group_id", property = "groupId", jdbcType = JdbcType.INTEGER), @Result(column = "block_number", property = "blockNumber", jdbcType = JdbcType.BIGINT), @Result(column = "trans_hash", property = "transHash", jdbcType = JdbcType.VARCHAR), @Result(column = "trans_index", property = "transIndex", jdbcType = JdbcType.INTEGER), @Result(column = "block_timestamp", property = "blockTimestamp", jdbcType = JdbcType.TIMESTAMP), @Result(column = "user_address", property = "userAddress", jdbcType = JdbcType.VARCHAR), @Result(column = "record_type", property = "recordType", jdbcType = JdbcType.TINYINT), @Result(column = "gas_value", property = "gasValue", jdbcType = JdbcType.BIGINT), @Result(column = "gas_remain", property = "gasRemain", jdbcType = JdbcType.BIGINT), @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP), @Result(column = "modify_time", property = "modifyTime", jdbcType = JdbcType.TIMESTAMP) })
    TbGas selectByPrimaryKey(@Param("id") Integer id, @Param("recordMonth") Integer recordMonth);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @UpdateProvider(type = TbGasSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TbGas record, @Param("example") TbGasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @UpdateProvider(type = TbGasSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") TbGas record, @Param("example") TbGasExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @UpdateProvider(type = TbGasSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbGas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @Update({ "update tb_gas", "set chain_id = #{chainId,jdbcType=INTEGER},", "group_id = #{groupId,jdbcType=INTEGER},", "block_number = #{blockNumber,jdbcType=BIGINT},", "trans_hash = #{transHash,jdbcType=VARCHAR},", "trans_index = #{transIndex,jdbcType=INTEGER},", "block_timestamp = #{blockTimestamp,jdbcType=TIMESTAMP},", "user_address = #{userAddress,jdbcType=VARCHAR},", "record_type = #{recordType,jdbcType=TINYINT},", "gas_value = #{gasValue,jdbcType=BIGINT},", "gas_remain = #{gasRemain,jdbcType=BIGINT},", "create_time = #{createTime,jdbcType=TIMESTAMP},", "modify_time = #{modifyTime,jdbcType=TIMESTAMP}", "where id = #{id,jdbcType=INTEGER}", "and record_month = #{recordMonth,jdbcType=INTEGER}" })
    int updateByPrimaryKey(TbGas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @Insert({ "<script>", "insert into tb_gas (record_month, ", "chain_id, group_id, ", "block_number, trans_hash, ", "trans_index, block_timestamp, ", "user_address, record_type, ", "gas_value, gas_remain, ", "create_time, modify_time)", "values<foreach collection=\"list\" item=\"detail\" index=\"index\" separator=\",\">(#{detail.recordMonth,jdbcType=INTEGER}, ", "#{detail.chainId,jdbcType=INTEGER}, #{detail.groupId,jdbcType=INTEGER}, ", "#{detail.blockNumber,jdbcType=BIGINT}, #{detail.transHash,jdbcType=VARCHAR}, ", "#{detail.transIndex,jdbcType=INTEGER}, #{detail.blockTimestamp,jdbcType=TIMESTAMP}, ", "#{detail.userAddress,jdbcType=VARCHAR}, #{detail.recordType,jdbcType=TINYINT}, ", "#{detail.gasValue,jdbcType=BIGINT}, #{detail.gasRemain,jdbcType=BIGINT}, ", "#{detail.createTime,jdbcType=TIMESTAMP}, #{detail.modifyTime,jdbcType=TIMESTAMP})</foreach></script>" })
    int batchInsert(List<TbGas> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_gas
     *
     * @mbg.generated
     */
    @SelectProvider(type = TbGasSqlProvider.class, method = "getOneByExample")
    @Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true), @Result(column = "record_month", property = "recordMonth", jdbcType = JdbcType.INTEGER, id = true), @Result(column = "chain_id", property = "chainId", jdbcType = JdbcType.INTEGER), @Result(column = "group_id", property = "groupId", jdbcType = JdbcType.INTEGER), @Result(column = "block_number", property = "blockNumber", jdbcType = JdbcType.BIGINT), @Result(column = "trans_hash", property = "transHash", jdbcType = JdbcType.VARCHAR), @Result(column = "trans_index", property = "transIndex", jdbcType = JdbcType.INTEGER), @Result(column = "block_timestamp", property = "blockTimestamp", jdbcType = JdbcType.TIMESTAMP), @Result(column = "user_address", property = "userAddress", jdbcType = JdbcType.VARCHAR), @Result(column = "record_type", property = "recordType", jdbcType = JdbcType.TINYINT), @Result(column = "gas_value", property = "gasValue", jdbcType = JdbcType.BIGINT), @Result(column = "gas_remain", property = "gasRemain", jdbcType = JdbcType.BIGINT), @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP), @Result(column = "modify_time", property = "modifyTime", jdbcType = JdbcType.TIMESTAMP) })
    Optional<TbGas> getOneByExample(TbGasExample example);
}
