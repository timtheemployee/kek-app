package kek.foundation.terrorhistory.presentation.filter

import kek.foundation.terrorhistory.data.attacktypes.AttackType
import kek.foundation.terrorhistory.data.countries.Country
import kek.foundation.terrorhistory.data.groups.Group
import kek.foundation.terrorhistory.data.region.Region
import kek.foundation.terrorhistory.data.targettypes.TargetType

sealed class FilterItem

class CountriesItem(val countries: List<Country>, val selected: MutableSet<Country> = mutableSetOf()): FilterItem()

class AttackTypesItem(val attackTypes: List<AttackType>, val selected: MutableSet<AttackType> = mutableSetOf()): FilterItem()

class GroupsItem(val groups: List<Group>, val selected: MutableSet<Group> = mutableSetOf()): FilterItem()

class RegionsItem(val regions: List<Region>, val selected: MutableSet<Region> = mutableSetOf()): FilterItem()

class TargetTypesItem(val targetTypes: List<TargetType>, val selected: MutableSet<TargetType> = mutableSetOf()): FilterItem()