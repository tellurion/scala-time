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

import org.threeten.bp.{Clock => JC}

/** Factory object for obtaining instances of [[Clock]].
  *
  * The default no-argument `apply` method differs from the underlying constructor in that it explicitly returns
  * the '''UTC''' Zone Clock from the current system time. Use `apply(ZoneID)` to specify an alternative zone,
  * or [[Clock.systemZone]] to obtain a Clock from the current system time and zone.
  *
  * @example
  * {{{
  *             import codes.reactive.scalatime._
  *
  *             // Obtain a Clock from the current system UTC time
  *             val utcClock = Clock()
  *
  *             // Obtain a Clock fixed to the current instant
  *             val fixed = Clock.fixed(Instant())
  * }}}
  *
  * @since 0.1.0
  */
object Clock extends ClockFactory {

  def apply(): Clock = JC.systemUTC()

  def apply(zone: ZoneID): Clock = JC.system(zone)

  def systemZone: Clock = JC.systemDefaultZone()

  def fixed(instant: Instant, zone: ZoneID): Clock = JC.fixed(instant, zone)

  def fixed(instant: Instant): Clock = JC.fixed(instant, ZoneOffset.UTC)
}