package com.mical.sm.service;

import com.mical.sm.pojo.Department;

import java.util.List;

/**
 * �� �� �ƣ�DepartmentService
 * �� �� ����������Ϣ��ҵ���ӿ�
 * ����ʱ�䣺2019/5/23 10:49
 * �����ˣ�Mical
 */
public interface DepartmentService {
    /**
     * ��Ӳ���
     * @param department ���Ŷ���
     */
    void add(Department department);

    /**
     * ɾ��һ������
     * @param id ����id
     */
    void remove(Integer id);

    /**
     * �༭������Ϣ������id�༭��������
     * @param department ���Ŷ���
     */
    void edit(Department department);

    /**
     * ��ȡ����
     * @param id ����id
     * @return ���Ŷ���
     */
    Department get(Integer id);

    /**
     * ��ȡ���в���
     * @return �����б�
     */
    List<Department> getAll();
}
