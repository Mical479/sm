package com.mical.sm.dao;

import com.mical.sm.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * �� �� �ƣ�DepartmentDao
 * �� �� ����������Ϣ����ӿ�
 * ����ʱ�䣺2019/5/23 10:32
 * �����ˣ�Mical
 */
@Repository("departmentDao")
public interface DepartmentDao {
    /**
     * ���벿����Ϣ
     * @param department ���Ŷ���
     */
    void insert(Department department);

    /**
     * ɾ��ĳ������
     * @param id ����id
     */
    void delete(Integer id);

    /**
     * ����ĳ����������
     * @param department ���Ŷ���
     */
    void update(Department department);

    /**
     * ���ݲ���id��ѯ������Ϣ
     * @param id ����id
     * @return ���Ŷ���
     */
    Department selectById(Integer id);

    /**
     * ��ѯ���в���
     * @return �����б�
     */
    List<Department> selectAll();
}
