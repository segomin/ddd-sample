package com.sshop.asset.query.resource;

import com.sshop.asset.command.domain.resource.ResourceNo;
import org.springframework.data.repository.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ResourceDataDao extends Repository<ResourceData, ResourceNo> {

	Optional<ResourceData> findBy
}
