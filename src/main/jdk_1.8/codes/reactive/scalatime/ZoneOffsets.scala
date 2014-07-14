/*******************************************************************
 * See the NOTICE file distributed with this work for additional   *
 * information regarding Copyright ownership.  The author/authors  *
 * license this file to you under the terms of the Apache License, *
 * Version 2.0 (the "License"); you may not use this file except   *
 * in compliance with the License.  You may obtain a copy of the   *
 * License at:                                                     *
 *                                                                 *
 *     http://www.apache.org/licenses/LICENSE-2.0                  *
 *                                                                 *
 * Unless required by applicable law or agreed to in writing,      *
 * software distributed under the License is distributed on an     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY          *
 * KIND, either express or implied.  See the License for the       *
 * specific language governing permissions and limitations         *
 * under the License.                                              *
 *******************************************************************/

package codes.reactive.scalatime

import java.time.{ZoneOffset => ZO}

/** Provides default time zone [[ZoneOffset]] instances, as well as methods to create them.
  * @since  0.1.0
  */
private[scalatime] trait ZoneOffsets extends AbstractZoneOffsets {

  def apply(temporal: TemporalAccessor): ZoneOffset = ZO.from(temporal)

  def apply(hours: Int): ZoneOffset = ZO.ofHours(hours)

  def apply(hours: Int, minutes: Int): ZoneOffset = ZO.ofHoursMinutes(hours, minutes)

  def apply(hours: Int, minutes: Int, seconds: Int): ZoneOffset = ZO.ofHoursMinutesSeconds(hours, minutes, seconds)

  def apply(offsetId: String): ZoneOffset = ZO.of(offsetId)

  val EAT: ZoneOffset = apply(3)

  val UTC: ZoneOffset = ZO.UTC

  val MIN: ZoneOffset = ZO.MIN

  val MAX: ZoneOffset = ZO.MAX
}