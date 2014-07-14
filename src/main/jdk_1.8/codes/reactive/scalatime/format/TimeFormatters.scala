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

package codes.reactive.scalatime.format

import java.time.format.{DateTimeFormatter => DF}
import java.util.Locale

import codes.reactive.scalatime._


/** Provides standard [[DateTimeFormatter]] instances, as well as methods to create them.
  * @since 0.1.0
  */
trait TimeFormatters extends AbstractTimeFormatters {

  val Iso: ISO = new ISO {}


  val `RFC1123/RFC822`: DateTimeFormatter = DF.RFC_1123_DATE_TIME

  override val Internet: DateTimeFormatter = `RFC1123/RFC822`

  def apply(pattern: String): DateTimeFormatter = DF.ofPattern(pattern)

  def apply(pattern: String, locale: Locale): DateTimeFormatter = DF.ofPattern(pattern, locale)


  protected trait ISO extends AbstractIsoFormatters {
    val Basic: DateTimeFormatter = DF.BASIC_ISO_DATE

    val Date: DateTimeFormatter = DF.ISO_DATE

    val Time: DateTimeFormatter = DF.ISO_TIME

    val Instant: DateTimeFormatter = DF.ISO_INSTANT

    val LocalDate: DateTimeFormatter = DF.ISO_LOCAL_DATE

    val LocalDateTime: DateTimeFormatter = DF.ISO_LOCAL_DATE_TIME

    val LocalTime: DateTimeFormatter = DF.ISO_LOCAL_TIME

    val OffsetDate: DateTimeFormatter = DF.ISO_OFFSET_DATE

    val OffsetDateTime: DateTimeFormatter = DF.ISO_OFFSET_DATE_TIME

    val OffsetTime: DateTimeFormatter = DF.ISO_OFFSET_TIME

    val OrdinalDate: DateTimeFormatter = DF.ISO_ORDINAL_DATE
  }

}
