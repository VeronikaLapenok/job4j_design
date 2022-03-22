package generics.store;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {
    @Test
    public void whenAddAndFindThenRoleNameIsDoctor() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Seller"));
        roleStore.add(new Role("2", "Doctor"));
        roleStore.add(new Role("3", "Driver"));
        Role result = roleStore.findById("2");
        assertThat(result.getRoleName(), is("Doctor"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Seller"));
        Role result = roleStore.findById("2");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindRoleNameIsSeller() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Seller"));
        roleStore.add(new Role("2", "Doctor"));
        roleStore.add(new Role("1", "Driver"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName(), is("Seller"));
    }

    @Test
    public void whenReplaceThenRoleNameIsDoctor() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Seller"));
        roleStore.replace("1", new Role("1", "Doctor"));
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName(), is("Doctor"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Seller"));
        roleStore.delete("1");
        Role result = roleStore.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteThenRoleNameIsSeller() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Seller"));
        roleStore.delete("2");
        Role result = roleStore.findById("1");
        assertThat(result.getRoleName(), is("Seller"));

    }
}