package kek.foundation.terrorhistory.presentation.filter

import kek.foundation.terrorhistory.data.attacktypes.AttackType
import kek.foundation.terrorhistory.data.countries.Country
import kek.foundation.terrorhistory.data.groups.Group
import kek.foundation.terrorhistory.data.region.Region
import kek.foundation.terrorhistory.data.targettypes.TargetType

sealed class FilterItem

class CountriesItem(val countries: List<Country>): FilterItem()

class AttackTypesItem(val attackTypes: List<AttackType>): FilterItem()

class GroupsItem(val groups: List<Group>): FilterItem()

class RegionsItem(val regions: List<Region>): FilterItem()

class TargetTypesItem(val targetTypes: List<TargetType>): FilterItem()