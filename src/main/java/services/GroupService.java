package services;

import dao.GroupDao;
import models.GroupEntity;

import java.util.List;

public class GroupService implements CommonService<GroupEntity>{
    private GroupDao groupDao = new GroupDao();
    private GroupEntity group = new GroupEntity();

    public GroupService(){}

    @Override
    public GroupEntity find(int id) {
        return groupDao.findById(id);
    }

    @Override
    public void save(GroupEntity group) {
        groupDao.save(group);
    }

    @Override
    public void delete(GroupEntity group) {
        groupDao.delete(group);
    }

    @Override
    public void update(GroupEntity group) {
        groupDao.update(group);
    }

    @Override
    public List<GroupEntity> getAll() {
        return groupDao.getAll();
    }

    public void addGroup(String groupName){
        save(new GroupEntity(groupName));
        System.out.println("\nAdded");
    }

    public void updateGroupNumber(int id,String GrNumb){
        group = find(id);
        group.setGroopNumber(GrNumb);
        update(group);
        System.out.println("\nUpdated");
    }

    public void deleteGroup(int idGroup){
        group = find(idGroup);
        delete(group);
        System.out.println("\nDeleted");
    }



    public void showAll(){
        List<GroupEntity> list = getAll();
        System.out.println("====================");
        if(list.size()==0)
            System.out.println("There are no groups");
        else{
            for (GroupEntity g:getAll()) {
                System.out.println(g.toString());
            }
        }
        System.out.println("====================");
    }

}
