#!/usr/bin/env bash

nms="net/minecraft/server"
export MODLOG=""
PS1="$"
basedir="$(cd "$1" && pwd -P)"

workdir=$basedir/work
minecraftversion=$(cat $basedir/BuildData/info.json | grep minecraftVersion | cut -d '"' -f 4)
decompiledir=$workdir/$minecraftversion

export importedmcdev=""
function import {
	export importedmcdev="$importedmcdev $1"
	file="${1}.java"
	target="$basedir/Spigot-Server/src/main/java/$nms/$file"
	base="$decompiledir/$nms/$file"

	if [[ ! -f "$target" ]]; then
		export MODLOG="$MODLOG  Imported $file from mc-dev\n";
		echo "Copying $base to $target"
		cp "$base" "$target"
	fi
}

(
	cd $basedir/Spigot-Server/
	lastlog=$(git log -1 --oneline)
	if [[ "$lastlog" = *"mc-dev Imports"* ]]; then
		git reset --hard HEAD^
	fi
)

#import AxisAlignedBB

(
	cd $basedir/Spigot-Server/
	git add src -A
	echo -e "mc-dev Imports\n\n$MODLOG" | git commit src -F -
)
