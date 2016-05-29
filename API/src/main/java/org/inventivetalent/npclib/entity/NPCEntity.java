/*
 * Copyright 2016 inventivetalent.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and contributors and should not be interpreted as representing official policies,
 *  either expressed or implied, of anybody else.
 */

package org.inventivetalent.npclib.entity;

import org.bukkit.event.entity.CreatureSpawnEvent;
import org.inventivetalent.npclib.annotation.ExtraMethod;
import org.inventivetalent.npclib.npc.NPCAbstract;
import org.inventivetalent.npclib.watcher.MethodWatcher;
import org.inventivetalent.vectors.d3.Vector3DDouble;

public interface NPCEntity {

	void setMethodWatcher(MethodWatcher methodWatcher);

	NPCAbstract getNPC();

	//	<T extends Entity> T getBukkitEntity();

	boolean methodCalled(String name, Object[] args);

	Object methodCalled(String name, Object superValue, Object[] args);

	// Overwritten methods

	void setLocation(double x, double y, double z, float yaw, float pitch);

	// Helpers

	@ExtraMethod("public void spawn() {\n"
						 + "  this.world.addEntity(this);\n"
						 + "}")
	void spawn();

	@ExtraMethod("public void spawn(org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason spawnReason) {\n"
						 + "  this.world.addEntity(this, spawnReason);\n"
						 + "}")
	void spawn(CreatureSpawnEvent.SpawnReason spawnReason);

	@ExtraMethod("public org.inventivetalent.vectors.d3.Vector3DDouble getLocationVector() {\n"
						 + "  return new org.inventivetalent.vectors.d3.Vector3DDouble(this.locX, this.locY, this.locZ);\n"
						 + "}")
	Vector3DDouble getLocationVector();

}
