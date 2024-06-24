package ru.evgen.cooking_chef_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evgen.cooking_chef_project.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
